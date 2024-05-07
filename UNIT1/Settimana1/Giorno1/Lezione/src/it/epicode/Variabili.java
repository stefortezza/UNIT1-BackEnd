package it.epicode;

import java.util.Arrays;

public class Variabili {
    public static void main(String[] args) {
        int x; //Innanzitutto questa è una Dichiarazione di variabile!!
        x = 4; //Questa invece è l'assegnazione a una variabile!
        x = 124; //Questa è una nuova assegnazione, e prende come valore quest'ultimo!

        boolean b = true;

        char c = 'd'; //IMPORTANTE: Inserire la singola apice '';

        double d = 3.3; //Inserimento di NUMERI DECIMALI;

        String s = "Benvenuto al corso di Back-End Epicode della classe FS0"; //IMPORTANTE: Inserire i doppi apici ""!

        String fraseConcatenata = s + x;

        final int y = 3; //Variabile constante non più modificabile (FINAL),quindi se inseriamo sotto y = mumber; lui ci darà errore.


        //SOUT + INVIO
        System.out.println(fraseConcatenata);

        byte b2 = 100;

//        x = b2;

        b2 = (byte)x;

        System.out.println(b2);

        int [] numeri = new int[6];

        numeri[0] = -3;
        numeri[1] = 6 + 3;

        System.out.println(numeri[1] + numeri[0]);

        int [] numeri2 = {3,5,7};

        System.out.println(Arrays.toString(numeri2));

    }


}
