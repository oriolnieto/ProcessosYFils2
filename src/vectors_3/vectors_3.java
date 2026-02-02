package vectors_3;


import java.util.Random;
import java.util.Scanner;



public class vectors_3 {

    /**
     * Aquest programa busca el valor màxim d’un vector utilitzant programació
     * concurrent amb fils (Threads).
     *
     * El programa demana a l’usuari el tamany del vector i el nombre de fils
     * que s’utilitzaran. El vector s’inicialitza amb valors aleatoris.
     *
     * El vector es divideix en blocs de posicions consecutives, de manera que
     * cada fil processa un bloc i calcula el seu valor màxim local.
     *
     * Si el nombre de posicions del vector no es pot repartir exactament entre
     * els fils, les posicions sobrants són processades pel fil principal.
     *
     * El fil principal espera que tots els fils acabin la seva execució mitjançant
     * el mètode join() i, posteriorment, compara els màxims locals per obtenir
     * el valor màxim final del vector.
     *
     * Finalment, el programa mostra el valor màxim trobat i indica quin fil
     * (o el fil principal) l’ha localitzat.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Introdueix el valor del vector: ");
        int nPosicions = sc.nextInt(); // nombre total de posicions del vector

        System.out.println("Introdueix el nombre de fills: ");
        int numFills = sc.nextInt(); // nombre de fills a executar

        int [] vector = new int[nPosicions];
        for (int i=0; i<nPosicions; i++){
            vector[i] = rand.nextInt(1000);
        }

        // Tantes posicions com tinguin els vectors entre 3 fils --> per tant, X posicions (n)/3 fils
        int midaBloc = nPosicions / numFills; // quantes posicions del vector li toquen a cad
        int index = 0; // comptador que indica com s'incrementa les posicions en relació al vector

        FilVector[] fils = new FilVector[numFills];

        // execució del fills
        for (int i=0; i<numFills; i++){
            int inici = index; // inici del fil
            int fi = index + midaBloc; // final del fil
            fils[i] = new FilVector(vector , index , fi , inici , i);
            fils[i].start();
            index = fi; // S'actualitza la nova posicio del fil anterior i s'executa el seguent
        }

        // Troba el valor maxim del fil executat
        int MaximFilPrincipal = Integer.MIN_VALUE;

        if (index < nPosicions) {
            MaximFilPrincipal = vector[index];

            for (int i = index + 1; i < nPosicions; i++) {
                if (MaximFilPrincipal < vector[i]) {
                    MaximFilPrincipal = vector[i];
                }
            }
        }

        // Cooldown dels altres fils en busca del seu valor maxim
        int MaximFilSecundo = MaximFilPrincipal;
        int winner = -1; // valor per defecte, cap fil ha trobat el maxim ara mateix

        for (FilVector fil : fils) {
            try {
                fil.join(); // cooldown d'espera que adjunta els fils pendents a executar per ser llençats posteriorment

                if (fil.getMax() > MaximFilSecundo) {
                    MaximFilSecundo = fil.getMax();
                    winner = fil.getIdThread();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Valor màxim del vector: " + MaximFilSecundo);

        // el valor del guanyador no varia, el fil principal SEMPRE sera 0 ja que es el primer fil
        // cap fil ha superat el màxim del fil principal, el guanyador és el fil principal
        // en cas que no algun fil ha trobat un valor més gran i el guanyador compta amb l'id d'aquest fil

        if (winner == -1) {
            System.out.println("El vector principal ha trobat el màxim final"); // el guanyador sempre serà 0, 0 es el fil principal

        } else {
            System.out.println("El maxim l'ha trobat el fil amb aquest id: " + winner);
        }

    }
}
