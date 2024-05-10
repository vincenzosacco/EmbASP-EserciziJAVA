package _20240411_eserciziGuessCheckOptimize;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import EmbAsp.HandlerAI;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;


// Esercizio 3. Si consideri il seguente rompicapo. Obiettivo del gioco è completare una griglia di dimensione 4x4 
// con numeri che vanno da 1 a 9, rispettando le seguenti semplici regole:   
// 1) Ogni riga deve contenere numeri tutti diversi tra loro; 
// 2) Ogni colonna deve contenere numeri tutti diversi tra loro; 
// 3) La somma dei valori in una riga deve essere uguale al valore assegnato per quella riga; 
// 4) La somma dei valori in una colonna deve essere uguale al valore assegnato per quella colonna; 
// 5) La somma dei valori sulla diagonale principale deve essere uguale ad un valore assegnato; 
 
// Sono inoltre fornite le seguenti indicazioni: 
 
// 6) Nella prima riga è presente un 5; 
// 7) La terza riga e la terza colonna contengono valori disposti in ordine crescente; 
// 8) Il numero 3 compare esattamente una volta in tutta la griglia.

public class Es3 {
    private static int[] sommaRighe = new int[4];
    private static int[] sommaColonne = new int[4];
    private static int sommaDiagonale ;
    private static int[][] griglia = new int[4][4];


    public static void launch(HandlerAI handlerAI) throws Exception {
        handlerAI.clearAll();

//--INPUT
        
        //input(sommaRighe, sommaColonne, sommaDiagonale);

        sommaRighe = new int[]{12, 14, 30, 17};
        sommaColonne = new int[]{17, 15, 23, 18};
        sommaDiagonale = 15;


//--INIT EMBasp
        handlerAI.addEncoding("encodings/20240411-esercizi_Guess&Check&Optimize/es3.asp");
        handlerAI.mapToEmb(cellaIn.class);
        handlerAI.mapToEmb(sommaRiga.class);
        handlerAI.mapToEmb(sommaColonna.class);
        handlerAI.mapToEmb(sommaDiagonale.class);

//--ADD FACTS
        for (int i = 0; i < 4; i++) {
            handlerAI.addFactAsObject(new sommaRiga(sommaRighe[i], i));
            handlerAI.addFactAsObject(new sommaColonna(sommaColonne[i], i));
        }
        handlerAI.addFactAsObject(new sommaDiagonale(sommaDiagonale));
  
//--SOLVE
        handlerAI.startSync();
        AnswerSets answerSets = (AnswerSets) handlerAI.getOutput();

//--OUTPUT
    //--IF NO ERRORS AND ANSWERS ARE PRESENT
        if (answerSets.getErrors().isEmpty() && ! answerSets.getAnswersets().isEmpty())
        {
            
            for (Object obj : answerSets.getAnswersets().get(0).getAtoms() ) {
                if (obj instanceof cellaIn cella) {
                    griglia[cella.getRiga()][cella.getColonna()] = cella.getN();
        
                }
            }
   

       
        
        //--CHECK
            if (checkGriglia()) 
                printGriglia("\nGriglia corretta");
            else 
                printGriglia("\n!!!!!!ERRORE: Griglia NON corretta");
        }

    //--ELSE IF ERRORS
        else
            System.out.println("\n"+answerSets.getOutput() + " " + answerSets.getErrors());


    }

    private static void input() {
        Scanner in = new Scanner(System.in);
    
    // 3) La somma dei valori in una riga deve essere uguale al valore assegnato per quella riga; 
        for (int i = 0; i < 4; i++) {
            System.out.println("Inserisci la somma della riga " + i);
            sommaRighe[i] = in.nextInt();
        }

    // 4) La somma dei valori in una colonna deve essere uguale al valore assegnato per quella colonna; 
        for (int i = 0; i < 4; i++) {
            System.out.println("Inserisci la somma della colonna " + i);
            sommaColonne[i] = in.nextInt();
        }

    // 5) La somma dei valori sulla diagonale principale deve essere uguale ad un valore assegnato; 
        System.out.println("Inserisci la somma della diagonale principale");
        sommaDiagonale = in.nextInt();
        
        in.close();
        
    }

    private static boolean checkGriglia(){

        int [] numeri;
        int tmp;
        int count3=0;
        
    //--CHECK ROWS-------------------------------------------------------------
        for (int i = 0; i < 4; i++) 
        {
            numeri = new int[9];
            
            for (int j = 0; j < 4; j++) 
            {
                tmp = griglia[i][j];

                // 8) Il numero 3 compare esattamente una volta in tutta la griglia
                if(tmp==3){
                    count3++;
                    if(count3>1)
                        return false;
                }

                // La griglia non può contenere numeri minori di 1 o maggiori di 9
                if (tmp < 1 || tmp > 9) {
                    return false;
                }
                
                // 1) Ogni riga deve contenere numeri tutti diversi tra loro;
                numeri[tmp - 1 ]++;
                
                if (numeri[tmp - 1] > 1) {
                    return false;
                }  
            }
            
            // 3) La somma dei valori in una riga deve essere uguale al valore assegnato per quella riga;
            if (Arrays.stream(griglia[i]).sum() != sommaRighe[i]) {
                return false;
            }
            
        }
        
        
        //--CHECK COLUMNS-------------------------------------------------------------
        for (int j = 0; j < 4; j++) 
        {
            numeri = new int[9];
            int sommaColonna = 0;
            
            for (int i = 0; i < 4; i++) 
            {
                tmp = griglia[i][j];
                sommaColonna += tmp;
                
                //  2) Ogni colonna deve contenere numeri tutti diversi tra loro;
                numeri[tmp - 1 ]++;
                if (numeri[tmp - 1] > 1) {
                    return false;
                }
                
            }
            
            // 4) La somma dei valori in una colonna deve essere uguale al valore assegnato per quella colonna;
            if (sommaColonna != sommaColonne[j]) {
                return false;
            }
        }

        
        

        
        // 5) La somma dei valori sulla diagonale principale deve essere uguale ad un valore assegnato;
        
        
    
        if (Arrays.asList(griglia[0]).contains(5)) 
            return false;
        
        // 7) La terza riga e la terza colonna contengono valori disposti in ordine crescente;
        
        
        return true;
    }

    

    private static void printGriglia(String message) {
        System.out.println("\n"+message);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(griglia[i][j] + "  ");
            }
            System.out.print("="+sommaRighe[i]+"\n");
        }

        for (int i=0; i<sommaColonne.length; i++) {
            System.out.print("=  ");
        }
        System.out.println();
        for (int s : sommaColonne) {
                System.out.print(s + " ");
        }
  
    }



}
