package _20240411_eserciziGuessCheckOptimize;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
import it.unical.mat.embasp.languages.asp.SymbolicConstant;

import java.util.Objects;


/**
 * This class represents an arc between two <b>Oriented Graph</b> nodes.
 */
//arc(Node1,Node2).
@Id("edge")
public class edge {
    @Param(0)
    private int orig;
    @Param(1)
    private int dest;
    @Param(2)
    private SymbolicConstant color;

//-----------------CONSTRUCTORs-----------------
    public edge (){
    }
    
    public edge(int orig, int dest, SymbolicConstant color) {
        this.orig = orig;
        this.dest = dest;
        this.color = color;
    }

//-----------------GETTERs AND SETTERs-----------------    
    public int getOrig() {
        return orig;
    }

    public void setOrig(int orig) {
        this.orig = orig;
    }


    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }


    public SymbolicConstant getColor() {
        return color;
    }

    public void setColor(SymbolicConstant color) {
        this.color = color;
    }
    
//-----------------OVERRIDEs-----------------
    @Override
    public String toString() {
        return " edge(" +
                orig +
                "," + dest +
                "," + color+
                ") ";
    }

    /**
     * Two edges are equals if they have the same origin and destination nodes AND the same color.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof edge edge)) return false;
        return (orig == edge.orig ) && (dest == edge.dest) && (color == edge.color);

    }


    @Override
    public int hashCode() {
        return Objects.hash(orig, dest, color);
    }

}
