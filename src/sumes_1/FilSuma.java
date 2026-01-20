package sumes_1;
import java.util.Scanner;

public class FilSuma implements Runnable {

    String aNomFil;
    int Resultat;

    public FilSuma(String pNomFil) {
        aNomFil = pNomFil;
    }

    public String gNomFil() {
        return aNomFil;
    }

    public int getResultat() {
        return Resultat;
    }

    public void setResultat(int resultat) {
        Resultat = resultat;
    }

    @Override
    public void run() {
        synchronized (System.in) {  // si no sincronitzem l'entrada demana els 4 a la vegada, ja que estem en un fil, l'encunciat diu que demani el fil el propi nombre, si ho fessim desde el principal no faria falta
            Scanner sc = new Scanner(System.in);
            System.out.println("Fil " + aNomFil + " solicita un número enter: ");
            int num = sc.nextInt();


            Resultat = 0;

            for (int i = 0; i <= num; i++) {
                Resultat += i;
            }
        }
    }
}