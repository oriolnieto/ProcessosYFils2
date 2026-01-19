package vectors_3;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class vectors_3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Introdueix el valor del vector: ");
        int n = sc.nextInt();

        System.out.println("Introdueix el nombre de fills: ");
        int fills = sc.nextInt();

        int [] vector = new int[n];
        for (int i=0; i<n; i++){
            vector[i] = rand.nextInt(1000);
        }

        int mida = n / fills;
        int index = 0;

        FilVector[] fils = new FilVector[fills];

        for (int i=0; i<fills; i++){
            int inici = index;
            int fi = index + fills;
            fils[i] = new FilVector(vector , index , fi , inici);
            fils[i].start();
            index = fi;
        }

        int 


        if () {

        } else {

        }

        System.out.println("Valor màxim: " +  "Fil: " + );



    }
}
