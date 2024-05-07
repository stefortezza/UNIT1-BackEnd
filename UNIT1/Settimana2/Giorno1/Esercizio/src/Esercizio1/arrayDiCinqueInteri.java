package Esercizio1;

import java.util.Random;

public class arrayDiCinqueInteri {
    public static int[] generaArrayCasuale() {
        Random random = new Random();

        int[] numeri = new int[5];

        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = random.nextInt(11);
        }
        return numeri;
    }
}