package _20240414_tombola;

//    Si progetti e si implementi una applicazione Java (o Python, o C#)
//    per generare cartelle per la tombola napoletana.
//    In particolare, l'applicazione dovrà chiedere all'utente quante cartelle desidera,
//    generarle e visualizzarle su standard output.
//    Se il numero di cartelle generabili fosse minore del numero specificato dall'utente,
//    visualizzare su standard output tutte le cartelle generabili.


import EmbAsp.HandlerAI;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;

import java.util.ArrayList;
import java.util.Scanner;

public class GeneratoreCartelle {
    public static void launch(HandlerAI handlerAI) throws Exception {
        handlerAI.clearAll();
//--INPUT
       System.out.println("Numero di cartelle desiderate: ");
       Scanner in = new Scanner(System.in);
       int nCartelle = in.nextInt();
       in.close();
       
       ArrayList<Cartella> cartelle = new ArrayList<Cartella>();

//--INIT HANDLER
        handlerAI.addEncoding("encodings/20240414-tombola/generatoreCartelle.asp");
        try {

            handlerAI.mapToEmb(in.class);
        } catch (ObjectNotValidException | IllegalAnnotationException e) {
            throw new RuntimeException(e);
        }

//--ADD FACTS


//--ANSWERSET
        //handlerAI.addOption("--printonlyoptimum");
        handlerAI.setNumberOfAnswerSet(nCartelle);
        handlerAI.startSync();
        AnswerSets answerSets = (AnswerSets) handlerAI.getOutput();

        if (! answerSets.getOptimalAnswerSets().isEmpty()){

            for (AnswerSet as: answerSets.getOptimalAnswerSets()){

                Cartella toAdd = new Cartella();
                for (Object atom: as.getAtoms()){
                    if (atom instanceof in)
                        toAdd.setNumber( ((in)atom).getN(), ((in)atom).getRiga(), ((in)atom).getColonna());
                }

                if (checkCartella(toAdd))
                    cartelle.add(toAdd);

            }

            cartelle.forEach( Cartella::print );
            System.out.println("\nCartelle generate: " + cartelle.size());
        }

        if (answerSets.getAnswersets().isEmpty()) {
            System.out.println();
            if (answerSets.getErrors().isEmpty())
                System.out.println(answerSets.getOutput());
            else
                System.out.println(answerSets.getErrors());
        }
   }





    private static boolean checkCartella(Cartella cartella){
    //--ogni cartella deve contenere esattamente 15 numeri compresi tra 1 e 90;
        if (cartella.getCount() != 15)
            throw new RuntimeException("Cartella non valida");

    //--ciascuna colonna deve contenere almeno 1 numero, e non piu' di 2;
        for (int j = 0; j < Cartella.COLS; j++){
            int count = 0;
            for (int i = 0; i < Cartella.ROWS; i++){
                if (cartella.getNumber(i, j) != 0)
                    count++;
            }
            if (count < 1 || count > 2)
                throw new RuntimeException("Colonna " + j + " presente "+ count + " volte");
        }
    //--ciascuna riga deve contenere esattamente 5 numeri;
        for (int i = 0; i < Cartella.ROWS; i++){
            int count = 0;
            for (int j = 0; j < Cartella.COLS; j++){
                if (cartella.getNumber(i, j) != 0)
                    count++;
            }
            if (count != 5)
                throw new RuntimeException("Riga " + i + " presente "+ count + " volte");
        }
    
        
    //--la prima colonna puo' contenere solo numeri  tra 1 e 9;
    //--la seconda colonna numeri tra 10 e 19; la terza tra 20 e 29
    //--e cosi' via fino all'ottava, che contiene i numeri tra 70 e 79;
    //--la nona colonna puo' contenere numeri tra 80 e 90;

        int lowBound =1; int uppBound=9; 
        for (int j = 0; j < Cartella.COLS; j++){
            for (int i = 0; i < Cartella.ROWS; i++){
                
                int toCheck = cartella.getNumber(i, j);
                if (toCheck != 0 && ( toCheck < lowBound || toCheck > uppBound))
                    throw new RuntimeException( "CARTELLA_" + cartella.getId() +" Numero " +
                                        toCheck + " nella colonna " + j + " non valido");
            }

            if (j == 0) { lowBound = 10; uppBound = 19; }
            else 
            if (j == 7) { lowBound = 80; uppBound = 90; }
            else{
                lowBound +=10; 
                uppBound +=10;
            }

        }
                
        return true;
    }


}
