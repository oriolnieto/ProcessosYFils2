package n_parells_4;
import java.util.Scanner;
import java.util.Random;

public class n_parells_4 {

    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("Introdueix el tamany del vector: ");
        int tamany = scan.nextInt();

        System.out.println("Introdueix el nombre de fills del vector: ");
        int nombreFills = scan.nextInt();

        int vector[] = new int [tamany];

        for (int i=0;i<tamany;i++){
            vector[i] = rand.nextInt(100);
        }

        FilParells[] fills  = new FilParells[nombreFills];

        int bloc = tamany/nombreFills;
        int inici = 0;
        int fi = 0;

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
