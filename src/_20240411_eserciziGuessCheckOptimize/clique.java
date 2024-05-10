package _20240411_eserciziGuessCheckOptimize;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

// clique(N)
@Id("clique")
/**
 * This class represents a clique of size N.
 * Empty Constructor value is 0.
 */
public class clique {
    @Param(0)
    private int n;

    public clique() {
        this.n = 0;
    }
    public clique(int n) {
        assert n >= 0;
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }


    @Override
    public String toString() {
        return " clique(" +
                n +
                ") ";
    }
}
