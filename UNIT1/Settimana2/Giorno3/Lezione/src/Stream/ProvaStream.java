package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProvaStream {
    public static void main(String[] args) {
        List<String> lista = List.of("java", "javascript", "html", "css", "python", "html");

        lista.stream(); //AGGANGIARE LA LISTA AD UNO STRAM, E VIENE COPIATO IL TUTTO IN QUESTO FLUSSO.

        System.out.println("METODO FILTER < 5: ");
        lista.stream().filter(s -> s.length() < 5).forEach(s -> System.out.println(s)); //FILTRA SOLO LE PAROLE CON LUNGHEZZA MINORE DI 5, QUINDI DA 0 A 4.
        System.out.println();
        System.out.println("METODO LIMIT DI 3: ");
        lista.stream().limit(3).forEach(s -> System.out.println(s)); //CREA UN STREAM E LE LIMITA A 3, QUINDI PRENDERA' SOLO LE PRIME 3 DALL'ARRAY LIST.OF
        System.out.println();
        System.out.println("METODO MAP: ");
        lista.stream().map(s -> s.length()).forEach(s -> System.out.println(s)); //COSI' MI DA LA LUNGHEZZA DELLE PAROLE CONTENENTI NELL'ARRAY!
        System.out.println();
        System.out.println("METODO PER ELIMINARE I DUPLICATI - DISTINCT: ");
        lista.stream().distinct().forEach(s -> System.out.println(s));
        System.out.println();
        System.out.println("METODO SORTED: ");
        lista.stream().sorted((s1, s2) -> s2.compareTo(s1)).forEach(s -> System.out.println(s));
        System.out.println();
        int addizione = lista.stream().map(s -> s.length()).reduce(0, (somma, l) -> somma + l);
        //CON QUESTO METODO PRIMA TRASFORMA L'ARRAY IN NUMERI CON IL METODO MAP, E POI GLI ABBIAMO DETTO CON IL METODO
        //REDUCE DI FARE LA SOMMA DI TUTTI I NUMERI. JAVA HA 4; HTML HA 4; ECC... TOT = ADDIZIONE!
        System.out.println("METODO REDUCE: ");
        System.out.println(addizione);
        System.out.println();
        System.out.println("METODO TOTALE: ");
        int totale = lista.stream().map(s -> s.length()).filter(l -> l < 5).reduce(0, (somma, l) -> somma + l);
        System.out.println(totale);
        System.out.println();
        System.out.println("METODO FINALE: ");
        String finale = lista.stream().sorted().distinct().collect(Collectors.joining(", "));
        System.out.println(finale);
        System.out.println();
        System.out.println("METODO SET: ");
        Set<Integer> numeri = lista.stream().map(s -> s.length()).collect(Collectors.toSet()); //INVIAMO QUESTE LUNGHEZZE IN UN SET
        System.out.println(numeri);
        List<String> lista2 = List.of("epicode", "accenture", "byte");
        List<List<String>> lista3 = List.of(lista, lista2);
        System.out.println();
        System.out.println("STAMPA LISTA UNITA: ");
        List<String> listaFinale = lista3.stream()
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(listaFinale);

    }
}
