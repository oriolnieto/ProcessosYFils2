package fibonacci_2;

public class FilFibonacci implements  Runnable {

    private int numero;
    private int resultat;

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public FilFibonacci(int numero) {
       this.numero = numero;
    }

    @Override
    public void run() {
        int a = 0;
        int b = 1;
        int c = 0;

        for (int contador = 0; contador < numero; contador++) {
            if (numero == 0){
                resultat = 0;
            }
            else {
                c = a + b; // la suma de update sera el primer más el segundo en fibonacci
                a = b; // igualamos el valor que habia en b para a
                b = c; // igualamos el valor de c en b, que sera la suma que hemos echo previamente, y asi sucesivamente
            }
            resultat = b;
        }
    }
}