package fibonacci_2;

import java.util.Scanner;
import fibonacci_2.FilFibonacci;

public class fibonaccis_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Cuants fils vols crear?, es a dir fins a quin nombre de fibonacci vols fer?");
        int fil = scan.nextInt();

        Thread[] fils = new Thread[fil];
        FilFibonacci[] filFibonacci = new FilFibonacci[fil];

        for (int i = 0; i < fil; i++) {
            filFibonacci[i] = new FilFibonacci(i); // guardar en array
            fils[i] = new Thread(filFibonacci[i]);
            fils[i].start();
        }

        for (int i = 0; i < fil; i++) {
            try {
                fils[i].join(); // s'ha de fer el join apart perque si n'ho es fa tot sincronitzat es a dir, es fa de forma secuencial, ademés de que ho necessitem per a que acabi cada fil el seu calcul de fibonacci i no peti
            } catch (InterruptedException e) {
                System.out.println("Error fent el Join!");
            }
        }

        for (int i = 0; i < fil; i++) {
            System.out.println(filFibonacci[i].getResultat());
        }
    }
}