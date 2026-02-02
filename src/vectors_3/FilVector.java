package vectors_3;


// Classe objecte del fil, aquesta classe es compón de l'objecte de cada fil amb els seus atributs corresponents, on el seu id és un comptador amb increment
// Amb els seus setters i getters corresponents

public class FilVector extends Thread {

    private int[] vector;
    private int start;
    private int end;
    private int max;
    private int idThread;

    public FilVector(int[] vector, int start, int end, int max, int idThread) {
        this.vector = vector;
        this.start = start;
        this.end = end;
        this.max = Integer.MIN_VALUE;
        this.idThread = idThread;

    }


    // El métode runn() del fil es sobrescriu en un bucle for on el vector en la posició i s'iniciarà
    // i acabarà quan el valor de la posició i sigui inferior o igual que la posició final de la geometria en el espai del vector.

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
           if (vector[i] > max) {
                max= vector[i];
           }
        }
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }
    public void setEnd(int end) {
        this.end = end;
    }

    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = Integer.MIN_VALUE;
    }

    public int getIdThread() {
        return idThread;
    }
    public void setIdThread(int idThread) {
        this.idThread = idThread;
    }
}
