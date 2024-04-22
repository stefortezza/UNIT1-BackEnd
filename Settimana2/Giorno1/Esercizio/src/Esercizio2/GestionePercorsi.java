package Esercizio2;

import java.util.Scanner;

public class GestionePercorsi {
    private calcoloPercorsi calcolo;

    public GestionePercorsi() {
        calcolo = new calcoloPercorsi();
    }

    public void gestisciPercorso() {
        boolean eseguiPercorso = true;
        double risultato;
        Scanner scanner = new Scanner(System.in);

        while (eseguiPercorso) {
            try {
                if (eseguiPercorso) {
                    risultato = calcolo.Percorso();
                    System.out.println("Il consumo di carburante per chilometro è: " + risultato);
                    return;
                }
            } catch (ArithmeticException e) {
                eseguiPercorso = false;
                System.out.println(e.getMessage());
                System.out.println("Inserisci nuovamente i dati.");

                System.out.print("Inserisci i chilometri percorsi: ");
                double chilometri = scanner.nextDouble();
                System.out.print("Inserisci i litri consumati: ");
                double litri = scanner.nextDouble();

                while (litri == 0) {
                    System.out.println("I litri non possono essere zero. Inserisci nuovamente i dati.");
                    System.out.print("Inserisci i chilometri percorsi: ");
                    chilometri = scanner.nextDouble();
                    System.out.print("Inserisci i litri consumati: ");
                    litri = scanner.nextDouble();
                }
            }
        }
        risultato = calcolo.Percorso();
    }
}
