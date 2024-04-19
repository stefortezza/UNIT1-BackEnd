package PlayerMultimediale;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        LettoreMultimedialeImpl lettore = new LettoreMultimedialeImpl();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci il tipo di multimediale (1 per Audio, 2 per Video, 3 per Immagine):");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            if (scelta < 1 || scelta > 3) {
                System.out.println("Errore: Scelta non valida!");
                return;
            }

            System.out.println("Inserisci il titolo: ");
            String titolo = scanner.nextLine();

            int durata = 0;
            int volume = 0;
            int luminosita = 0;

            if (scelta == 1 || scelta == 2) {
                System.out.println("Inserisci la durata:");
                durata = scanner.nextInt();

                System.out.println("Inserisci il volume:");
                volume = scanner.nextInt();
            }

            if (scelta == 2) {
                System.out.println("Inserisci la luminosita:");
                luminosita = scanner.nextInt();
            } else if (scelta == 3) {
                System.out.println("Inserisci la luminosita:");
                luminosita = scanner.nextInt();
            }

            ElementoMultimediale elemento = null;

            if (scelta == 1) {
                elemento = new Audio(titolo, durata, volume);
            } else if (scelta == 2) {
                elemento = new Video(titolo, durata, volume, luminosita);
            } else if (scelta == 3) {
                elemento = new Immagine(titolo, luminosita);
            }

            lettore.aggiungiElemento(elemento, i);
        }

        int riproduci = -1;
        while (riproduci != 0) {
            System.out.println("Quale elemento vuoi riprodurre? (da 1 a 5, 0 per uscire):");
            riproduci = scanner.nextInt();

            if (riproduci == 0) {
                System.out.println("A presto! Buona giornata :)");
                break;
            }

            lettore.eseguiElemento(riproduci - 1);
        }
    }
}
