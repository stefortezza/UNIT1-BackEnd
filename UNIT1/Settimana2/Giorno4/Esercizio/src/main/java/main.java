import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        List<Product> prodotti = new ArrayList<>();

        Product prodotto1 = new Product(1, "libro 1", "books", 110);
        Product prodotto1a = new Product(4, "libro 1AA", "books", 130);
        Product prodotto2 = new Product(2, "libro 2", "baby", 135);
        Product prodotto3 = new Product(3, "libro 3", "boys", 105);

        prodotti.add(prodotto1);
        prodotti.add(prodotto2);
        prodotti.add(prodotto3);
        prodotti.add(prodotto1a);

        List<Customer> clienti = new ArrayList<>();

        Customer cliente1 = new Customer(1L, "Stefano", 3);
        Customer cliente2 = new Customer(2L, "Marco", 2);
        Customer cliente3 = new Customer(3L, "Luca", 2);

        clienti.add(cliente1);
        clienti.add(cliente2);
        clienti.add(cliente3);

        List<Order> ordini = new ArrayList<>();
        List<Product> prodottiOrdine1 = new ArrayList<>();
        List<Product> prodottiOrdine2 = new ArrayList<>();
        List<Product> prodottiOrdine3 = new ArrayList<>();
        List<Product> prodottiOrdine4 = new ArrayList<>();


        prodottiOrdine1.add(prodotto1);
        prodottiOrdine2.add(prodotto2);
        prodottiOrdine3.add(prodotto3);
        prodottiOrdine4.add(prodotto1a);


        Order ordine1 = new Order(1, "Aperto", LocalDate.of(2024, 2, 10), LocalDate.of(2024, 02, 01), prodottiOrdine1, cliente1);
        Order ordine2 = new Order(1, "Chiuso", LocalDate.of(2024, 3, 10), LocalDate.of(2024, 02, 01), prodottiOrdine2, cliente1);
        Order ordine3 = new Order(3, "Chiuso", LocalDate.of(2024, 4, 10), LocalDate.of(2024, 03, 01), prodottiOrdine3, cliente2);
        Order ordine4 = new Order(4, "Aperto", LocalDate.of(2024, 1, 10), LocalDate.of(2024, 05, 01), prodottiOrdine4, cliente3);

        ordini.add(ordine1);
        ordini.add(ordine2);
        ordini.add(ordine3);
        ordini.add(ordine4);

        Stream<Product> streamProdotti = prodotti.stream();
        Stream<Order> streamOrdini = ordini.stream();
        Stream<Customer> streamClieni = clienti.stream();


        System.out.println("ESERCIZIO 1: ");
        Map<Customer, List<Order>> m1 = ordini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
        m1.forEach(((customer, orders) -> System.out.println(customer + " -> " + orders)));
        System.out.println();

        System.out.println("ESERCIZIO 2: ");
        Map<Customer, Double> m2 = ordini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(value -> value.getProducts().stream().mapToDouble(Product::getPrice).sum())));
        m2.forEach(((customer, sommaOrdini) -> System.out.println(customer + " -> " + sommaOrdini)));
        System.out.println();

        System.out.println("ESERCIZIO 3: ");
        Map<String, Optional<Product>> m3 = prodotti.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
        m3.forEach(((category, prodottoMax) -> System.out.println(category + " -> " + prodottoMax.get())));
        System.out.println();

        System.out.println("ESERCIZIO 4: ");
        OptionalDouble media = ordini.stream()
                .flatMap(order -> order.getProducts().stream()).mapToDouble(Product::getPrice).average();
        System.out.println(media.getAsDouble());
        System.out.println();

        System.out.println("ESERCIZIO 4.2: ");
        Double media2 = ordini.stream()
                .collect(Collectors.averagingDouble(value -> value.getProducts().stream()
                        .mapToDouble(Product::getPrice).sum()));
        System.out.println(media2);
        System.out.println();

        System.out.println("ESERCIZIO 6: ");

        String prodottiSting = prodotti.stream()
                .map(product -> product.getId() +
                        "@" + product.getName() + "@" +
                        product.getCategory() + "@" +
                        product.getPrice())
                .collect(Collectors.joining("#"));
        System.out.println(prodottiSting);

        File file = new File("./../persistence/prova.txt");
        try {
            FileUtils.writeStringToFile(file, prodottiSting, Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("ESERCIZIO 7: ");
        try {
            String str = FileUtils.readFileToString(file, Charset.defaultCharset());

            String[] prodottiStr = str.split("#");

            Arrays.stream(prodottiStr).forEach(s -> System.out.println(s));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
