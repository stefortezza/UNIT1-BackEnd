package Esercizio1;

import java.util.Scanner;

public class gestisciArray {
    public static void gestisciArray() {
        int[] arrayCasuale = arrayDiCinqueInteri.generaArrayCasuale();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Array di interi con valori casuali tra 1 e 10:");
        for (int i = 0; i < arrayCasuale.length; i++) {
            System.out.print(arrayCasuale[i] + " ");
        }
        System.out.println();

        int posizione;
        int numero;
        do {
            System.out.println("Inserisci la posizione (da 1 a 5) e il numero da inserire (0 per uscire):");
            posizione = scanner.nextInt();

            if (posizione == 0) {
                break;
            }

            if (posizione < 1 || posizione > 5) {
                System.out.println("Posizione non valida. Deve essere compresa tra 1 e 5.");
                continue;
            }

            numero = scanner.nextInt();

            arrayCasuale[posizione - 1] = numero;

            System.out.println("Nuovo stato dell'array:");
            for (int i = 0; i < arrayCasuale.length; i++) {
                System.out.print(arrayCasuale[i] + " ");
            }
            System.out.println();
        } while (true);

        System.out.println("Programma terminato.");
    }
}
