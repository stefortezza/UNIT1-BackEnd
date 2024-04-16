import java.util.Scanner;

public class Operazioni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il primo numero");
        int n1 = scanner.nextInt();
        System.out.println("Inserisci il secondo numero");
        int n2 = scanner.nextInt();

        System.out.println("Inserisci l'operazione");
        char operazione = scanner.next().charAt(0);


        //ALGORITMO

        int risultatoCorretto = 0;

        if (operazione == '+') {
            risultatoCorretto = n1 + n2;
        } else if (operazione == '-') {
            risultatoCorretto = n1 - n2;
        } else if (operazione == '*') {
            risultatoCorretto = n1 * n2;
        } else if (operazione == '/') {
            risultatoCorretto = n1 / n2;
        } else {
            System.out.println("OPERAZIONE NON TROVATA");
            return;
        }

        System.out.println("Inserisci il risultato");
        int risultato = scanner.nextInt();

        if (risultatoCorretto == risultato) {
            System.out.println("RISULTATO CORRETTO!");
        } else {
            System.out.println("RISULTATO ERRATO! IL RISULTATO GIUSTO E'" + risultatoCorretto);
        }
    }
}
