package _20240411_eserciziGuessCheckOptimize;

import EmbAsp.HandlerAI;
import it.unical.mat.embasp.languages.asp.AnswerSets;

import java.util.Arrays;
import java.util.Scanner;


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
    private static int[] check_sommaRighe = new int[4];
    private static int[] check_sommaColonne = new int[4];
    private static int check_sommaDiagonale ;
    private static int[][] griglia = new int[4][4];


    public static void launch(HandlerAI handlerAI) throws Exception {
        handlerAI.clearAll();

//--INPUT
        
        //input(sommaRighe, sommaColonne, sommaDiagonale);

        check_sommaRighe = new int[]{12, 14, 30, 17};
        check_sommaColonne = new int[]{17, 15, 23, 18};
        check_sommaDiagonale = 15;


//--INIT EMBasp
        handlerAI.addEncoding("encodings/20240411-esercizi_Guess&Check&Optimize/es3.asp");
        handlerAI.mapToEmb(cellaIn.class);
        handlerAI.mapToEmb(sommaRiga.class);
        handlerAI.mapToEmb(sommaColonna.class);
        handlerAI.mapToEmb(sommaDiagonale.class);

//--ADD FACTS
        for (int i = 0; i < 4; i++) {
            handlerAI.addFactAsObject(new sommaRiga(check_sommaRighe[i], i));
            handlerAI.addFactAsObject(new sommaColonna(check_sommaColonne[i], i));
        }
        handlerAI.addFactAsObject(new sommaDiagonale(check_sommaDiagonale));
  
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
            check_sommaRighe[i] = in.nextInt();
        }

    // 4) La somma dei valori in una colonna deve essere uguale al valore assegnato per quella colonna; 
        for (int i = 0; i < 4; i++) {
            System.out.println("Inserisci la somma della colonna " + i);
            check_sommaColonne[i] = in.nextInt();
        }

    // 5) La somma dei valori sulla diagonale principale deve essere uguale ad un valore assegnato; 
        System.out.println("Inserisci la somma della diagonale principale");
        check_sommaDiagonale = in.nextInt();
        
        in.close();
        
    }

    private static boolean checkGriglia(){
        
    //  1) Ogni riga deve contenere numeri tutti diversi tra loro;
    //  2) Ogni colonna deve contenere numeri tutti diversi tra loro;
        int [] numeri;
        int tmp;
    
    //  3) La somma dei valori in una riga deve essere uguale al valore assegnato per quella riga;

    //  4) La somma dei valori in una colonna deve essere uguale al valore assegnato per quella colonna;
        int sommaColonna = 0;
        
    //  5) La somma dei valori sulla diagonale principale deve essere uguale ad un valore assegnato;   
        int sommaDiagonale = 0;

    //  6) Nella prima riga è presente un 5;
        boolean trovato5 = false;

    //  7) La terza riga e la terza colonna contengono valori disposti in ordine crescente;

    //  8) Il numero 3 compare esattamente una volta in tutta la griglia
        int count3=0;

        
//--VISIT PER ROWS------------------------------------------------------------------------------------------------
        for (int i = 0; i < 4; i++) 
        {   
            //1)
            numeri = new int[9];
            //5)
            sommaDiagonale += griglia[i][i];
            
            for (int j = 0; j < 4; j++) 
            {
                tmp = griglia[i][j];

                //1) 
                numeri[tmp - 1 ]++;

                //8) 
                if(tmp==3){
                    count3++;
                    if(count3>1)
                        return false;
                }

    // La griglia non può contenere numeri ripetuti    
                if (numeri[tmp - 1] > 1) {
                    return false;
                }  

    // La griglia non può contenere numeri minori di 1 o maggiori di 9
                if (tmp < 1 || tmp > 9) {
                    return false;
                }

            }//for(j)
            
            //3)  
            if (Arrays.stream(griglia[i]).sum() != check_sommaRighe[i]) {
                return false;
            }

            
        }//for(i)
        
        //5)
        if (sommaDiagonale != check_sommaDiagonale) {
            return false;
        }
        
//--VISIT PER COLUMNS-------------------------------------------------------------
        for (int j = 0; j < 4; j++) 
        {   
            //2)
            numeri = new int[9];
            //4)
            sommaColonna = 0;
            
            for (int i = 0; i < 4; i++) 
            {
                tmp = griglia[i][j];
                
                //2) 
                numeri[tmp - 1 ]++;
                if (numeri[tmp - 1] > 1) 
                    return false;
                
                //4)
                sommaColonna += tmp;
            }
            
            //4) 
            if (sommaColonna != check_sommaColonne[j]) {
                return false;
            }
        }

        
        //6)
        for (int n : griglia[0]) {
            if (n == 5) 
                trovato5 = true;
        }
        if (!trovato5)
            return false;
        
        //7) 
        if  (
            griglia[2][0] > griglia[2][1] || griglia[2][1] > griglia[2][2] || griglia[2][2] > griglia[2][3] || //riga 3 crescente
            griglia[0][2] > griglia[1][2] || griglia[1][2] > griglia[2][2] || griglia[2][2] > griglia[3][2]    //colonna 3 crescente
            )
            return false;


        return true;
    }

    

    private static void printGriglia(String message) {
        System.out.println("\n"+message);

        for (int i = 0; i < 4; i++) {

            // | 1 | 2 | 3 | 4 | 5 |
            for (int j = 0; j < 4; j++) {
                System.out.print(griglia[i][j] + "  ");
            }

            System.out.print("|"+check_sommaRighe[i]+"\n");
        }

        for (int i=0; i<check_sommaColonne.length*3; i++) {
            System.out.print("-");
        }

        System.out.println();
        for (int s : check_sommaColonne) {
                System.out.print(s + " ");
        }

        System.out.println("|"+check_sommaDiagonale);
  
    }



}
