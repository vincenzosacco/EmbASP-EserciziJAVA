import EmbAsp.HandlerAI;


public class Main {
    public static void main(String[] args) {
        HandlerAI handlerAI = new HandlerAI();

        try {
    //--20240327-esercizi_G&C_per_casa
//        _20240327_esercizi_per_casa.es_2.Es2.launch(handlerAI);
//        _20240327_esercizi_per_casa.es_3.Es3.launch(handlerAI);

    //--20240414 - tombola embasp - testo
    //    _20240414_tombola.GeneratoreCartelle.launch(handlerAI);


    //--20240411_eserciziGuessCheckOptimize
//         _20240411_eserciziGuessCheckOptimize.Es1.launch(handlerAI);
//         _20240411_eserciziGuessCheckOptimize.Es2.launch(handlerAI);
         _20240411_eserciziGuessCheckOptimize.Es3.launch(handlerAI);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
