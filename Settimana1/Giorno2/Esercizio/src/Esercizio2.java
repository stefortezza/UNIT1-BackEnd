import java.util.Scanner;

public class Esercizio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci un numero tra 0 e 3");
        int numero = scanner.nextInt();
        switch (numero) {
            case 0:
                System.out.println("ZERO");
                break;
            case 1:
                System.out.println("UNO");
                break;
            case 2:
                System.out.println("DUE");
                break;
            case 3:
                System.out.println("TRE");
                break;
            default:
                System.out.println("ERRORE: VALORE ERRATO!");
        }
    }
}
