package vectors_3;

public class FilVector extends Thread {

    private int[] vector;
    private int start;
    private int end;
    private int max;
    private int idThread;

    public FilVector(int[] vector, int start, int end, int max) {
        this.vector = vector;
        this.start = start;
        this.end = end;
        this.max = max;
        this.idThread = 0;

    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
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
        this.max = max;
    }

    public int getIdThread() {
        return idThread;
    }
    public void setIdThread(int idThread) {
        this.idThread = idThread;
    }
}
