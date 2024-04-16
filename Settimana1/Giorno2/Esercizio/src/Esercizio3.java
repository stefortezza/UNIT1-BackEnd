import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inserisci una parola (digita ':q & :Q' per uscire):");
            String parola = scanner.nextLine();
            if (parola.equals(":q")) {
                System.out.println("Arrivederci!");
                break;
            } else if (parola.equals(":Q")) {
                System.out.println("Arrivederci!");
                break;
            }

            String[] caratteri = parola.split("");

            for (int i = 0; i < caratteri.length; i++) {
                System.out.print(caratteri[i]);
                if (i < caratteri.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}