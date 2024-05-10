package _20240411_eserciziGuessCheckOptimize;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

// sommaRiga(K,R)
@Id("sommaRiga")
public class sommaRiga {
    @Param(0)
    private int k;

    @Param(1)
    private int riga;

    public sommaRiga() {
        this.k = -1;
        this.riga = -1;
    }
    
    public sommaRiga(int k, int riga) {
        this.k = k;
        this.riga = riga;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getRiga() {
        return riga;
    }

    public void setRiga(int riga) {
        this.riga = riga;
    }

    @Override
    public String toString() {
        return "sommaRiga(" + k + "," + riga + ") ";
    }

    
    

    
}
