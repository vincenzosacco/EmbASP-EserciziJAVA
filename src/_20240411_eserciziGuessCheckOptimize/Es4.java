// Esercizio 4. 
// Sia G=<V,E> un grafo orientato definito tramite i predicati (fatti) 
// edge(Vertex1,Vertex2,Color), e vertex(N,Color), in cui gli archi e i nodi sono colorati con 3 colori 
// differenti (rosso, verde, blu). Stabilire se esiste un sottoinsieme SDIV di V avente  le seguenti proprietà:  
// 1. SDIV è non vuoto. 
// 2. presi due qualunque nodi v1 e v2 in SDIV, e dati i loro colori C1 e C2, nessun arco che li connette 
//    può essere di colore C1 o C2. 
// 3. la cardinalità (numero di nodi) di SDIV è massima. 


package _20240411_eserciziGuessCheckOptimize;

import java.util.ArrayList;
import java.util.Scanner;

import EmbAsp.HandlerAI;
import it.unical.mat.embasp.languages.asp.AnswerSets;



public class Es4 {
    private static ArrayList<String> vertexArray ;
    private static ArrayList<String> edgeArray ;

    public static void launch(HandlerAI handlerAI) throws Exception {
        handlerAI.clearAll();
//--INPUT
        input();

        
    //--INIT EMBasp
        handlerAI.addEncoding("encodings/20240411-esercizi_Guess&Check&Optimize/es4.asp");
        
    //--ADD FACTS
        for (String s : vertexArray)
            handlerAI.addFactAsString("vertex("+s+")");
        for (String s : edgeArray)
            handlerAI.addFactAsString("edge("+s+")");

    //ESEMPIO DELLA TRACCIA
        // handlerAI.addFactAsString("edge(2,3,r)");
        // handlerAI.addFactAsString("edge(1,2,r)");
        // handlerAI.addFactAsString("edge(1,3,b)");
        // handlerAI.addFactAsString("edge(1,4,g)");
        // handlerAI.addFactAsString("vertex(1,b)");
        // handlerAI.addFactAsString("vertex(2,g)");
        // handlerAI.addFactAsString("vertex(3,r)");
        // handlerAI.addFactAsString("vertex(4,b)");

        
       
//--SOLVE  
        handlerAI.startSync();
        AnswerSets answerSets = (AnswerSets) handlerAI.getOutput();

    

//--OUTPUT4
        
        if (!answerSets.getErrors().isEmpty()){
            System.out.println("\n\nErrore: "+answerSets.getErrors());
            System.out.println(answerSets.getOutput());
            return;
        }

        if (answerSets.getOptimalAnswerSets().isEmpty()) {
            System.out.println("\n\n!!!!Non esiste un sottoinsieme SDIV di V avente le proprietà richieste.");
            return;
        }
        
        else {
            System.out.println("\n\nEsiste almeno un sottoinsieme SDIV di V avente le proprietà richieste.");
            System.out.println(answerSets.getOptimalAnswerSets());
        }

    }

    private static void input(){
        Scanner in = new Scanner(System.in);

        
    //--NODES
        System.out.println("\n--------INSERIRE NODI DEL GRAFO--------");
        System.out.println("Digitare 'Q' per terminare l'inserimento dei nodi.");
        for (int i = 0; i<4; i++)
            System.out.println("*");

        System.out.print("COLORI: r=rosso, g=verde, b=blu\n");
        System.out.println("ESEMPIO --> per inserire il nodo (1,Blu) digitare : 1,b \n");
        
        vertexArray = new ArrayList<String>();
        String tmp = "";
        while (true)
        {
            System.out.print("Nodo,Colore: "); 
            tmp = in.next();
            if (tmp.equals("Q") || tmp.equals("q")) break;
            vertexArray.add(tmp);

        } 
    
    //--EDGES
        for (int i = 0; i<4; i++)
            System.out.println();
        System.out.println("\n--------INSERIRE ARCHI DEL GRAFO--------");
        System.out.println("Digitare 'Q' per terminare l'inserimento degli archi.");
        for (int i = 0; i<4; i++)
            System.out.println("*");
        System.out.print("COLORI: r=rosso, g=verde, b=blu\n");
        System.out.println("ESEMPIO --> per inserire l'arco (1,2,Blu) digitare : 1,2,b \n");

        
        tmp = "";
        edgeArray = new ArrayList<String>();
        while (true)
        {
            System.out.print("Origine,Destinazione,Colore: "); 
            tmp = in.next();
            if (tmp.equals("Q") || tmp.equals("q")) break;
            edgeArray.add(tmp);

        }
        
        in.close();
    }
}