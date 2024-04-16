import java.util.Scanner;

public class sconto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il prezzo da scontare");
        double prezzo = scanner.nextDouble();
        double prezzoFinale = 0;
        double prezzoFinaleConSpedizione = 0;

        if (prezzo < 30) {
            prezzoFinale = prezzo - prezzo * 0.12;
            if (prezzoFinale < 50) {
                prezzoFinaleConSpedizione = prezzoFinale + 7.5;
            } else {
                prezzoFinaleConSpedizione = prezzoFinale;
            }
        } else {
            prezzoFinale = prezzo - prezzo * 0.25;
            if (prezzoFinale > 50) {
                prezzoFinaleConSpedizione = prezzoFinale + 5;
            } else {
                prezzoFinaleConSpedizione = prezzoFinale + 7.5;
            }
        }

        System.out.println("Il prezzo finale scontato compreso di spedizione è di €" + prezzoFinaleConSpedizione);
    }
}