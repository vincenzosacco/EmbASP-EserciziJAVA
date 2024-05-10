package _20240327_esercizi_per_casa.es_3;

import EmbAsp.*;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;

import java.lang.reflect.InvocationTargetException;


public class Es3 {
    public static void launch(HandlerAI handlerAI){
//--INIT HANDLER
        handlerAI.clearAll();

        try {
            handlerAI.mapToEmb(in.class);
        } catch (ObjectNotValidException | IllegalAnnotationException e) {
            throw new RuntimeException(e);
        }

        handlerAI.addEncoding("encodings/20240327-esercizi_G&C_per_casa/es3.asp");




//--LAUNCH HANDLER
        handlerAI.showAllAnswerSet(true);
        handlerAI.startSync();

        AnswerSets as = (AnswerSets) handlerAI.getOutput();
        for (AnswerSet a  : as.getAnswersets()) {
            System.out.println();
            try {

                for(Object atom: a.getAtoms()){
                    if (atom instanceof in)
                        //if (a.getAtoms().size()!=4)
                            System.out.println(atom.toString());

                }
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                     InstantiationException e) {
                throw new RuntimeException(e);
            }


        }

        System.out.println("\n"+ as.getErrors());


    }
}