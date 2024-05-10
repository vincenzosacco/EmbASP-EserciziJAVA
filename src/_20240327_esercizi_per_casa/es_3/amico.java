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

//amico(A)
@Id("amico")
public class amico {

    @Param(0)
    private SymbolicConstant nome;

    // non verrà mappato in quanto non è annotato con @Param, ma lo uso per il metodo ToString
    private final static String name = "amico";

    public amico(){
    }

    public amico(SymbolicConstant nome) {
        this.nome = nome;
    }

    public SymbolicConstant getNome() {
        return nome;
    }


//    @Override
//    public String toString() {
//        return "in{" +
//                "amico=" + amico +
//                ", programma=" + programma +
//                ", giorno=" + giorno +
//                ", orario=" + orario +
//                '}';
//    }
}
