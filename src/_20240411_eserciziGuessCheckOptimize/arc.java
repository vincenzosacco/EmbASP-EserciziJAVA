package _20240411_eserciziGuessCheckOptimize;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

import java.util.Objects;


/**
 * This class represents an arc between two <b>Not Oriented Graph</b> nodes  .
 * Value -1 means that the arc is not initialized.
 */
//arc(Node1,Node2).
@Id("arc")
public class arc {
    @Param(0)
    private int node1;
    @Param(1)
    private int node2;

    public arc (){

        this.node1 = -1;
        this.node2 = -1;
    }
    public arc(int node1, int node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    public int getNode1() {
        return node1;
    }

    public void setNode1(int node1) {
        this.node1 = node1;
    }

    public int getNode2() {
        return node2;
    }

    public void setNode2(int node2) {
        this.node2 = node2;
    }

    @Override
    public String toString() {
        return " arc(" +
                node1 +
                "," + node2 +
                ") ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof arc arc)) return false;
        return (node1 == arc.node1 && node2 == arc.node2) || (node1 == arc.node2 && node2 == arc.node1);

    }


    @Override
    public int hashCode() {
        //return Objects.hash(node1, node2);
        // uso node1 + node2 per permettere che due archi con gli stessi nodi
        // ma in ordine diverso vengano considerati uguali
        return Objects.hash(node1 + node2);
    }
}
