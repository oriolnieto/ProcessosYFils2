package primer_5;

public class FilPrimer implements Runnable {

    private int numero;
    private int resultat;

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public FilPrimer(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {

        if (numero%2==0) {
            return false;
        }

        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
            return true;
    }
}