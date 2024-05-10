package _20240411_eserciziGuessCheckOptimize;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

// sommaDiagonale(K)
@Id("sommaDiagonale")
public class sommaDiagonale {
    @Param(0)
    private int k;

    public sommaDiagonale() {
        this.k = -1;
    }
    
    
    public sommaDiagonale(int k) {
        this.k = k;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "sommaDiagonale(" + k +") ";
    }

    
    

    
}
