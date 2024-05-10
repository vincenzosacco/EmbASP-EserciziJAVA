package _20240411_eserciziGuessCheckOptimize;

// Esercizio 1. Dato un grafo G = <N, A>, diciamo che G ha una cricca di dimensione k se c'è un insieme di k 
// nodi  tale  che  ogni  coppia  di  nodi  al  suo  interno  è  connessa  da  un  arco.  Scrivere  un  programma  ASP
// che calcoli tutte le cricche di dimensione data (tramite un fatto "clique(k)" -  Esempio: "clique(3).) di un dato
// grafo, rappresentato tramite la relazione binaria arc(Nodo1, Nodo2)

import EmbAsp.HandlerAI;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Es1 {
    public static void launch(HandlerAI handlerAI) throws Exception {
//--INPUT
        HashSet<Object> facts = input();

//--INIT EMBASP
        handlerAI.clearAll();
        handlerAI.mapToEmb( arc.class );
        handlerAI.mapToEmb( clique.class );
        handlerAI.addEncoding("encodings/20240411-esercizi_Guess&Check&Optimize/es1.asp");
        handlerAI.addFactsAsObjectArray(facts);

//--START SOLVE
        handlerAI.showAllAnswerSet(true);
        handlerAI.startSync();
        AnswerSets answerSets = (AnswerSets) handlerAI.getOutput();

        for (AnswerSet as : answerSets.getAnswersets()) {
            System.out.print("\n"+as);
        }

        System.out.println("\n"+answerSets.getErrors());
  

        

    }

    private static HashSet<Object> input() {
        System.out.println("\n------INSERIRE ARCHI DEL GRAFO, Inserire -1 per fermarsi------");
        Scanner in = new Scanner(System.in);

        HashSet<Object> facts = new HashSet<>();
        int tmp;
        while (true) {
            arc tmpArc = new arc();

            System.out.print("\nInserire nodo sorgente: ");
            tmp = in.nextInt();
            if (tmp == -1) break;
            tmpArc.setNode1(tmp);

            System.out.print("Inserire nodo destinazione: ");
            tmp = in.nextInt();
            if (tmp == -1) break;
            tmpArc.setNode2(tmp);

        //--CHECK IF THE ARC ALREADY EXISTS
            if (! facts.add(tmpArc)) {
                System.out.println("!!!!Arco già inserito!!!!");
            }

        }
        
        int k = -1;
        while (k < 0) {
            System.out.print("\nDimensione delle cricche (>=0 ): ");
            k = in.nextInt();
        }

        facts.add(new clique(k));



        in.close();
        return facts;
    }
    
}
