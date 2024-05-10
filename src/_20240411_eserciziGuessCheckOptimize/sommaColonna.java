package _20240411_eserciziGuessCheckOptimize;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

// sommaColonna(K,R)
@Id("sommaColonna")
public class sommaColonna {
    @Param(0)
    private int k;

    @Param(1)
    private int col;

    public sommaColonna() {
        this.k = -1;
        this.col = -1;
    }
    
    public sommaColonna(int k, int colonna) {
        this.k = k;
        this.col = colonna;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int colonna) {
        this.col = colonna;
    }

    @Override
    public String toString() {
        return "sommaColonna(" + k + "," + col + ") ";
    }

    
    

    
}
