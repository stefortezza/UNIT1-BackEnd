package Esercizio2;

import java.util.Scanner;

public class calcoloPercorsi {
    public double Percorso() throws ArithmeticException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci i chilometri percorsi: ");
        double km = scanner.nextDouble();
        System.out.println("Inserisci i litri di carburante consumati: ");
        double litro = scanner.nextDouble();

        if (litro == 0) {
            throw new ArithmeticException("Errore: Divisione per zero. Inserisci un valore diverso da zero per i litri di carburante.");
        }

        return km / litro;
    }
}
