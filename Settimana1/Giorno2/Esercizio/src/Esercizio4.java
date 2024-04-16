import java.util.Scanner;

public class Esercizio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci un numero intero");
        int numero = scanner.nextInt();

        for (int conta = numero; conta >= 0; conta--) {
            System.out.println(conta);
        }

        /*for (int conta = 0; conta <= numero; conta++) {
            System.out.println(conta);
        } */
    }
}
