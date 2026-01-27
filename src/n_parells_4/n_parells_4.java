package n_parells_4;
import java.util.Scanner;
import java.util.Random;


// El programa consta d'un programa que conteja nombres parells a partir de vectors generats aleatoriament i que aquest mitjançant quans vectors hi hagi
// contarà quants nombres parells hi ha.
// El vector té un tamany que ha de decidir l'usuari, el mateix amb quants fills compta el vector.
// Cada fil compta quants nombres parells es troben en el rang del vector assignat i realitza la suma de tots els resultats.

public class n_parells_4 {

    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("Introdueix el tamany del vector: ");
        int tamany = scan.nextInt();

        System.out.println("Introdueix el nombre de fills del vector: ");
        int nombreFills = scan.nextInt();

        // el vector es tracta d'una array que emmagtzema el tamany del vector
        int vector[] = new int [tamany];


        // en un bucle for com a paràmetre on la posició i es un comptador amb increment i que el tamany del vector en la posició i serà inferior mentre la posició i incrementa
        // el vector en la posició i compta amb un cooldown de 100 segons d'execució
        for (int i=0;i<tamany;i++){
            vector[i] = rand.nextInt(100);
        }

        // finalitzat el bucle, l'objecte de la classe emmagatzema el en una array el nombre de fils que ha indicat l'usuari
        FilParells[] fills  = new FilParells[nombreFills];


        // els vectors es troben en el espai, per cada bloc es divideix el tamany del vector i el nombre de fills d'aquest. On recorren des d'un principi fins un final en increment.
        int bloc = tamany/nombreFills;
        int inici = 0;
        int fi = 0;



        // declarades les variables en un altre bucle for la posició i torna a ser un comptador on en aquesta posició serà inferior al nombre de fills mentre es troba en increment
        // en un condicional on si i es notablement igual al nombre de fills -1, el tamany del vector determina el final
        // Però si que el final indica que un inici en increment + el calcul del bloc que ocupa el vector segons l'usuari
        // finalitzat el condicial tancant el bucle els fills que reben com objecte en la posició i reben com a parametre les dades d'aquests amb les seguents variables
        // i per tant quan es trobin en la posició s'inicien i com a condició de sortida quan es compleixi tota condició s'indicarà mitjançant una igualtat que el inici d'aquest determina
        // el final un cop hagi acabat i s'executin un rere l'altre.
        for (int i=0;i<nombreFills;i++) {
            if (i == nombreFills - 1) {
                fi = tamany;

            } else {
                fi = inici + bloc;
            }

            fills[i] = new FilParells(vector, inici, fi);
            fills[i].start();
            inici = fi;

        }

        // per determinar quants parells, s'indica mitjnaçant un comptador, que en un bloc try-catch es llença un nou bucle for com a paràmetre exactament igual a l'anterior
        // els fills en la posició i s'agrupen i els parells sempre seràn superiors o iguals al nombre de fills en la posició
        // i que indicaràn la resposta de quants nombres parells es troben en el rang del vector
        // es captura l'execpció en cas d'error. I si es compleix correctament es mostra per pantalla quants nombres parells hi ha 
            int parells = 0;
            try {
                for (int i = 0; i<nombreFills; i++) {
                    fills [i].join();
                    parells += fills[i].getAnswer();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Total de nombres parells: " + parells);

    }
}
