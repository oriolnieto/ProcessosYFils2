package n_parells_4;

// Classe objecte de la classe de fils/nombres parells de l'activitat 4

public class FilParells extends Thread {

    private int [] vector;
    private int inici;
    private int fi;
    private int answer;

    public FilParells(int[] vector , int inici, int fi) {
        this.vector = vector;
        this.inici = inici;
        this.fi = fi;
        this.answer = 0;
    }

    // el métode run() del fil es sobrescriu en un bucle for on la posició marca l'inici
    // i finalitzarà el bucle quan la posició i sigui inferior al final de la geometria en el espai, la posició i incrementa
    // mitjançant un condicional si el vector en la posició i es divideix entre 2 i es multiplica per 2,
    // indica notablement que el vector en la posició i despres de la operació no hi dona un nombre que no sigui parell ja que no hi ha residu.
    // es tanca el condicional i el bucle quan despres de la condició la resposta incrementa ja que es tracta d'un comptador.
    @Override
    public void run() {
        for(int i=inici;i<fi;i++){
            if ((vector[i] / 2) * 2 == vector[i]) {
                answer++;
            }
        }
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
