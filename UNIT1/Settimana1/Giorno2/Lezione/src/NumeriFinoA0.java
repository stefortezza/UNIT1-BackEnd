import java.util.Scanner;

public class NumeriFinoA0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int somma = 0;
        int contatore = 0;
        int numero;

//        do {
//            System.out.println("Inserisci un numero");
//            numero = scanner.nextInt();
//            somma = somma + numero;
//            contatore++;
//        } while (numero != 0);

//        double media = (double) somma / (contatore - 1);
//        System.out.println(media);

        System.out.println("Inserisci un numero");
        numero = scanner.nextInt();

        while (numero != 0) {
            somma = somma + numero;
            contatore++;
            System.out.println("Inserisci un numero");
            numero = scanner.nextInt();
        }

        double media = (double) somma / (contatore);
        System.out.println(media);
    }

}
