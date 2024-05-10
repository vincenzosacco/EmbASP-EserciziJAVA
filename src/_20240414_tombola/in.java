package _20240414_tombola;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

//in(N,Ca,R,Co)
@Id("in")
public class in {
    @Param(0)
    private int n;
    @Param(1)
    private int riga;
    @Param(2)
    private int colonna;

    public in() {}

    public in(int n, int riga, int colonna) {
        this.n = n;
        this.riga = riga;
        this.colonna = colonna;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getRiga() {
        return riga;
    }

    public void setRiga(int riga) {
        this.riga = riga;
    }

    public int getColonna() {
        return colonna;
    }

    public void setColonna(int colonna) {
        this.colonna = colonna;
    }

    @Override
    public String toString() {
        return " in(" +
                n +
                "," + riga +
                "," + colonna +
                ") ";
    }
}
