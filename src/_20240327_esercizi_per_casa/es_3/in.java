package _20240327_esercizi_per_casa.es_3;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
import it.unical.mat.embasp.languages.asp.SymbolicConstant;

/**
 Per poter definire l’input sotto forma di oggetti, è necessario che tali classi siano dei {@code JavaBean} e che
 siano arricchite dalle annotazioni: <p>

 {@code &#064;Id(  string_name ))}: il cui target deve essere la classe stessa e serve a definire il nome del predicato ASP a cui
 mappare gli oggetti della classe <p>

 {@code &#064;Param(  integer_position ))}: il cui target è un campo di una classe annotate con Id e serve a definire la
 posizione di tale campo negli atomi che rappresenteranno gli oggetti di tale classe
 */

//in(A,P,G,O)
@Id("in")
public class in {

    @Param(0)
    private SymbolicConstant amico;
    @Param(1)
    private SymbolicConstant programma;
    @Param(2)
    private SymbolicConstant giorno;
    @Param(3)
    private int orario;

    // non verrà mappato in quanto non è annotato con @Param, ma lo uso per il metodo ToString
    private final static String name = "in";

    public in(){
    }

    public in(SymbolicConstant amico, SymbolicConstant programma, SymbolicConstant giorno, int orario) {
        this.amico = amico;
        this.programma = programma;
        this.giorno = giorno;
        this.orario = orario;
    }

    public SymbolicConstant getAmico() {
        return amico;
    }

    public void setAmico(SymbolicConstant amico) {
        this.amico = amico;
    }

    public SymbolicConstant getProgramma() {
        return programma;
    }

    public void setProgramma(SymbolicConstant programma) {
        this.programma = programma;
    }

    public SymbolicConstant getGiorno() {
        return giorno;
    }

    public void setGiorno(SymbolicConstant giorno) {
        this.giorno = giorno;
    }

    public int getOrario() {
        return orario;
    }

    public void setOrario(int orario) {
        this.orario = orario;
    }

    public String toString() {
        return "in("+amico + "," + programma + "," + giorno + "," + orario + ")";

    }
}
