import java.util.Scanner;

public class bigliettoMuseo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci un'opzione tra 1 e 4");
        System.out.println("1: BAMBINO CON ETA' INFERIORE AI 6 ANNI");
        System.out.println("2: STUDENTE");
        System.out.println("3: PENSIONATO");
        System.out.println("4:TUTTI GLI ALTRI");
        int scelta = scanner.nextInt();

        //ALGORITMO CON ELSE IF

//        if (scelta == 1) {
//            System.out.println("Biglietto Gratuito");
//        } else if (scelta == 2) {
//            System.out.println("Costo del biglietto €8,00");
//        } else if (scelta == 3) {
//            System.out.println("Costo del biglietto €10,00");
//        } else if (scelta == 4) {
//            System.out.println("Costo del biglietto €15,00");
//        } else {
//            System.out.println("ERRORE: SCELTA ERRATA!");
//            return;
//        }
//
//        System.out.println("Insersici l'età");
//        int eta = scanner.nextInt();
//        if (eta <= 18) {
//
//        }

        //ALGORITMO CON SWITCH CASE, NON ACCETTA UN BOOLEANO!!

        switch (scelta) {
            case 1:
                System.out.println("Biglietto Gratuito!");
                break;
            case 2:
                System.out.println("Costo del biglietto €8,00");
                break;
            case 3:
                System.out.println("Costo del biglietto €10,00");
                break;
            case 4:
                System.out.println("Costo del biglietto €15,00");
                break;
            default:
                System.out.println("ERRORE: SCELTA ERRATA!");
                break; //NON E' NECESSARIO INSERIRLO VISTO CHE E' NEL DEFAULT!
        }
    }
}
