package primer_5;

public class FilPrimer implements Runnable {

    private int numero;
    private String resultat;

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public FilPrimer(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        if (esPrimer(numero)) {
            resultat = numero + " es prim.";
        }
        else {
            resultat = numero + " no es prim.";
            }
    }

    private boolean esPrimer(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}