import java.util.Scanner;

public class Esercizio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inserisci una stringa (digita ':q' per uscire):");
            String input = scanner.nextLine();

            if (input.equals(":q")) {
                System.out.println("Arrivederci!");
                break;
            } else if (input.equals(":Q")) {
                System.out.println("Arrivederci!");
                break;
            }

            String[] caratteri = input.split("");

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