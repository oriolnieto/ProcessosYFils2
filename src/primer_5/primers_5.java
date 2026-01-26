package primer_5;

import primer_5.FilPrimer;

import java.util.Scanner;

public class primers_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = 0;
        int contador = 0;

        while (num != -1) {
            System.out.println("Escriu un numero:");
             num = scan.nextInt();
             contador++;
        }

        Thread[] fils = new Thread[contador];
        FilPrimer[] filPrimers = new FilPrimer[contador];

        for (int i = 0; i < contador; i++) {
            filPrimers[i] = new FilPrimer(i); // guardar en array
            fils[i] = new Thread(filPrimers[i]);
            fils[i].start();
        }

        for (int i = 0; i < contador; i++) {
            try {
                fils[i].join(); // s'ha de fer el join apart perque si n'ho es fa tot sincronitzat es a dir, es fa de forma secuencial, ademés de que ho necessitem per a que acabi cada fil el seu calcul de fibonacci i no peti
            } catch (InterruptedException e) {
                System.out.println("Error fent el Join!");
            }
        }

        for (int i = 0; i < contador; i++) {
            System.out.println(filPrimers[i].getResultat());
        }
    }
}