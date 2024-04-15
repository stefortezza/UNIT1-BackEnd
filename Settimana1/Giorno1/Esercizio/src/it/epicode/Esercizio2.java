package it.epicode;

import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci una parola");
        String x = scanner.nextLine();

        System.out.println("Inserisci un'altra parola");
        String y = scanner.nextLine();

        System.out.println("Inserisci un'ultima parola");
        String z = scanner.nextLine();

        System.out.println(x + " " + y + " " + z);
//        System.out.println(z + " " + y + " "+ x);
    }
}
