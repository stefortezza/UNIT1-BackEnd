package Lambda;

import java.util.Comparator;
import java.util.TreeSet;

public class ProvaLambdaTre {
    public static void main(String[] args) {
        TreeSet<String> parole = new TreeSet<>((o1, o2) -> o2.compareTo(o1));

        parole.add("java");
        parole.add("html");
        parole.add("css");
        parole.add("javascript");

        //AD OGNI STRINGA GLI ASSOCIA LA STAMPA, LO FACCIAMO TRAMITE O forEach O TRAMITE for!!!
        parole.forEach(parola -> System.out.println(parola));

        //EQUIVALENTE A PRIMA!
        for (String s : parole) {
            /* System.out.println(s); */
        }

        //IL METODO remofeIf ACCETTA UNA ESPRESSIONE LAMBDA NELLA QUALE INSERIAMO LA CONDIZIONE PER LA QUALE
        //RIMUOVE UNA PAROLA NEL TREESET
        parole.removeIf(s -> s.contains("j") || s.contains("J")); //IN QUESTO CASO ELIMINA TUTTE LE PAROLE CHE CONTENTONO LA J

        System.out.println(parole);
    }
}

