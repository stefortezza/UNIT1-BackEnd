import java.util.*;
import java.util.stream.Collectors;

public class ProvaStream {
    public static void main(String[] args) {
        Product libro1 = new Product(100l, "Il signore degli anelli", "Libri", 101);
        Product libro2 = new Product(101L, "Il giorno nero", "Libri", 102);
        Product libro3 = new Product(102L, "Collision", "Libri", 10);
        Product libro4 = new Product(103L, "Marracash", "Libri", 13);
        Product baby1 = new Product(104L, "pannolini", "Baby", 7);
        Product baby2 = new Product(105L, "tutina", "Baby", 15);
        Product baby3 = new Product(106L, "cappello", "Baby", 10);
        Product boys1 = new Product(107L, "scarpe", "Boys", 70);
        Product boys2 = new Product(108L, "felpa", "Boys", 40);
        Product boys3 = new Product(109L, "pantalone", "Boys", 40);

        List<Product> prodotti = List.of(libro1, libro2, libro3, libro4, boys1, boys2, boys3, baby1, baby2, baby3);

        //creo una lista con i prezzi dei prodotti
        List<Double> l1 = prodotti.stream()
                .map(product -> product.getPrezzo())
                .collect(Collectors.toList());
        l1.forEach(n -> System.out.println(n));
        System.out.println();

        //creo un set di prezzi dei prodotti(elimino i duplicati dei prezzi rispetto all'esempio precedente)
        Set<Double> s1 = prodotti.stream().map(prodotto -> prodotto.getPrezzo()).collect(Collectors.toSet());
        s1.forEach(n -> System.out.println(n));
        System.out.println();

        //creo una mappa che contiene coppie costituite da id del prodotto e prezzo del prodotto
        //Product::getPrezzo && Product::getId -> è un metodo reference e sostituisce Lambda p -> p.get.Id()
        Map<Long, Double> m1 = prodotti.stream()
                /* .collect(Collectors.toMap(Product::getPrezzo)) */
                .collect(Collectors.toMap(product -> product.getId(), product -> product.getPrezzo()));
        m1.forEach((id, valore) -> System.out.println(id + " " + valore));
        System.out.println();

        //creo una mappa usando il groupingBy che raggruppa per categoria di prodotti
        Map<String, List<Product>> m2 = prodotti.stream().collect(Collectors.groupingBy(Product::getCategoria));
        m2.forEach((id, valore) -> System.out.println(id + " " + valore));
        System.out.println();

        //creo una mappa che raggruppa per categoria di prodotti
        // e ne stampa il numero totale di prodotti per ogni categoria
        Map<String, Long> m3 = prodotti.stream()
                .collect(Collectors.groupingBy(Product::getCategoria, Collectors.counting()));
        System.out.println(m3);
        System.out.println();

        //creo una mappa con cui raggruppo per categoria e ne calcola la media dei prezzi dei prodotti
        Map<String, Double> m4 = prodotti.stream()
                .collect(Collectors.groupingBy
                        (Product::getCategoria, Collectors.averagingDouble(Product::getPrezzo)));
        System.out.println(m4);
        System.out.println();

        //Calcola la somma dei prezzi dei prodotti
        Map<String, Double> m5 = prodotti.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategoria, Collectors.summingDouble(Product::getPrezzo)
                ));
        System.out.println(m5);
        System.out.println();

        //calcolo la somma di tutti i prezzi dei prodotti usando summingDouble di collect
        double somma = prodotti.stream()
                .map(Product::getPrezzo)
                .collect(Collectors.summingDouble(Double::doubleValue));

        System.out.println("SOMMA: " + somma);
        System.out.println();

        //calcolo la media di tutti i prezzi dei prodotti usando averagingDouble di collect
        double media = prodotti.stream()
                .map(Product::getPrezzo)
                .collect(Collectors.averagingDouble(Double::doubleValue));
        System.out.println("MEDIA: " + media);
        System.out.println();

        //calcolo una statistica di tutti i prezzi dei prodotti usando summarizingDouble di collect
        //otterro vari valori tra cui somme, media, max, min, count
        DoubleSummaryStatistics stat = prodotti.stream()
                .map(Product::getPrezzo)
                .collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println("STAT: " + stat);
        System.out.println();

        //creo una mappa partizionando il contenuto dello stram in 2 partizioni
        //una partizione verifica la condizione del partitioningBy, l'altra no
        //il tutto viene messo in una mappa
        Map<Boolean, List<Product>> m6 = prodotti.stream()
                .collect(Collectors.partitioningBy(p -> p.getPrezzo() < 50));

        m6.forEach((id, valore) -> System.out.println(id + " " + valore));
        System.out.println();

        //calcola la somma dei prezzi di prodotti
//        double somma2 = prodotti.stream()
//                .collect(Collectors.reducing(0.0, (s, elemento) -> s + elemento.()));
//        System.out.println(somma2);

        //ordino lo stream di prodotti secondo l'ordine decrescente del prezzo
        prodotti.stream()
                .sorted(Comparator.comparingDouble(Product::getPrezzo)
                        .reversed())
                .forEach(System.out::println);

        double somma3 = prodotti.stream()
                .mapToDouble(Product::getPrezzo).sum();
        System.out.println();
        System.out.println(somma3);

        //calcolo il MASSIMO dei prezzi dei prodotti con il metodo mapToDouble
        OptionalDouble max = prodotti.stream()
                .mapToDouble(Product::getPrezzo).max();
        System.out.println();
        System.out.println(max.getAsDouble());


    }
}
