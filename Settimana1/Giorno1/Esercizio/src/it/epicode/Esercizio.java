package it.epicode;

import java.util.Scanner;

public class Esercizio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci un numero");
        int x = scanner.nextInt();

        System.out.println("Inserisci un'altro numero");
        int y = scanner.nextInt();

        int z = x * y;

        concatena("Il risultato della moltiplicazione è: ", z);

    }

    public static void concatena (String s, int z) {
        System.out.println(s + z);
    }


    public  static String [] inserisciInArray (String[] parole, String s) {
        String [] newArray = new String[6];

        newArray[0] = parole[0];
        newArray[1] = parole[1];
        newArray[2] = s;
        newArray[3]=parole[2];
        newArray[4]=parole[3];
        newArray[5]=parole[4];

        return newArray;
    }


}
