import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci una parola!");
        String parola = scanner.next();
        boolean strigaPariDispari = strigaPariDispari(parola);
        System.out.println("La lunghezza della stringa è pari? " + strigaPariDispari);
    }

    public static boolean strigaPariDispari(String parola) {
        return parola.length() % 2 == 0;
    }
}
