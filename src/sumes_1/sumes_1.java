package sumes_1;

import java.util.Scanner;
import sumes_1.FilSuma;

public class sumes_1 {
    public static void main(String[] pArguments) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Cuants fils vols crear?");
        int fil = scan.nextInt();

        Thread[] fils = new Thread[fil];
        FilSuma[] filSuma = new FilSuma[fil];

        for (int i = 0; i < fil; i++) {
            filSuma[i] = new FilSuma("#" + (i+1)); // guardar en array
            fils[i] = new Thread(filSuma[i]);
            fils[i].start();
        }

        for (int i = 0; i < fil; i++) {
            try {
                fils[i].join(); // s'ha de fer el join apart perque si n'ho es fa tot sincronitzat es a dir, es fa de forma secuencial,
                // fins que no acabi el 1 no es fara el 2, en canvi si ho fem amb un bucle extern, inicia els 5 seguits
            } catch (InterruptedException e) {
                System.out.println("Error fent el Join!");
            }
        }

        System.out.println("Resultats Finals:");
        for (int i = 0; i < fil; i++) {
            System.out.println( "Nom: " + filSuma[i].gNomFil() + " Suma: " + filSuma[i].getResultat());
        }
    }
}