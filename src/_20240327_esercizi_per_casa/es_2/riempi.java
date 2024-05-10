package _20240327_esercizi_per_casa.es_2;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;


/**
 Per poter definire l’input sotto forma di oggetti, è necessario che tali classi siano dei {@code JavaBean} e che
 siano arricchite dalle annotazioni: <p>

 {@code &#064;Id(  string_name ))}: il cui target deve essere la classe stessa e serve a definire il nome del predicato ASP a cui
 mappare gli oggetti della classe <p>

 {@code &#064;Param(  integer_position ))}: il cui target è un campo di una classe annotate con Id e serve a definire la
 posizione di tale campo negli atomi che rappresenteranno gli oggetti di tale classe
 */

//in(A,P,G,O)
@Id("riempi")
public class riempi {

    @Param(0)
    private int x;
    @Param(1)
    private int y;
    @Param(2)
    private int n;


    // non verrà mappato in quanto non è annotato con @Param, ma lo uso per il metodo ToString
    private final static String name = "riempi";

    public riempi(){
    }

    public riempi(int x, int y, int n) {
        this.x = x;
        this.y = y;
        this.n = n;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getN() {
        return n;
    }

    public String toString() {
        return (name +"("+ x + "," + y + "," + n + ")");

    }
}
