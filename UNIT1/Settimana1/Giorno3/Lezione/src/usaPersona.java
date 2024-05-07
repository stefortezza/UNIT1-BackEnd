import java.util.Scanner;

public class usaPersona {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona[] persone = new Persona[3];

        for (int i = 0; i < persone.length; i++) {
            Persona persona = new Persona();

            System.out.println("Inserisci il nome della persona " + (i + 1) + ":");
            persona.nome = scanner.next();
            System.out.println("Inserisci il cognome della persona " + (i + 1) + ":");
            persona.cognome = scanner.next();
            System.out.println("Inserisci l'età della persona " + (i + 1) + ":");
            persona.eta = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Inserisci l'indirizzo della persona " + (i + 1) + ":");
            persona.indirizzo = scanner.nextLine();
//            System.out.println("Inserisci il tuo tipo Persona della persona " + (i + 1) + ":");
//            persona.tipoLavoro = scanner.nextLine();

            persone[i] = persona;

        }
        for (int i = 0; i < persone.length; i++) {
            System.out.println("Persona " + (i + 1) + ": " + persone[i].nome + " " + persone[i].cognome + ", di età " + persone[i].eta + ", residente in Via " + persone[i].indirizzo + persone[i].tipoLavoro);
        }
    }
}
