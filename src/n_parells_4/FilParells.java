package n_parells_4;

public class FilParells {

    private int [] vector;
    private int inici;
    private int fi;
    private int answer;

    public FilParells(int[] vector , int inici, int fi, int answer) {
        this.vector = vector;
        this.inici = inici;
        this.fi = fi;
        this.answer = answer;
    }

    public int[] getVector() {
        return vector;
    }
    public void setVector(int[] vector) {
        this.vector = vector;
    }
    public int getInici() {
        return inici;
    }
    public void setInici(int inici) {
        this.inici = inici;
    }
    public int getFi() {
        return fi;
    }
    public void setFi(int fi) {
        this.fi = fi;
    }
    public int getAnswer() {
        return answer;
    }
    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
