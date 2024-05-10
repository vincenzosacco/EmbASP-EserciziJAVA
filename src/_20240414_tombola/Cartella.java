package _20240414_tombola;


public class Cartella {
    private final int[][] numeri;

    private static int NEXT_ID= 0;
    private final int id;
//--i numeri devono essere distribuiti su 3 file e 9 colonne
    public static final int ROWS = 3;
    public static final int COLS = 9;

    private int count = 0;

    public Cartella() {
        numeri = new int[ROWS][COLS];
        id = ++NEXT_ID;
    }

    public void setNumber(int n, int row, int col){
        assert (n >= 1 && n <= 90);
        numeri[row][col] = n;
        count++;
    }

    /**
     * Restituisce il numero presente nella cartella alla posizione (row, col)
     * Se non è presente alcun numero, restituisce 0
     */
    public int getNumber(int row, int col){
        return numeri[row][col];
    }

    /**
     * Restituisce il numero di numeri presenti nella cartella
     */
    public int getCount(){
        return count;
    }

    public int getId(){ return id;}

    public void print(){
        System.out.println();

        for (int i = 0; i < ROWS; i++) {
            System.out.println();
            for (int j = 0; j < COLS; j++) {
                if (j>0) {
                    if (numeri[i][j - 1] > 9)
                        System.out.print("  " + numeri[i][j]);
                    else
                        System.out.print("   " + numeri[i][j]);
                }
                else
                    System.out.print(numeri[i][j]);
            }


        }
    }

}