import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        List<Product> prodotti = new ArrayList<>();

        Product prodotto1 = new Product(1, "libro 1", "books", 110);
        Product prodotto1a = new Product(4, "libro 1A", "books", 130);
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


        Order ordine1 = new Order(1, "Disponibile", LocalDate.now(), LocalDate.of(2024, 02, 01), prodottiOrdine1, cliente1);
        Order ordine2 = new Order(1, "Disponibile", LocalDate.now(), LocalDate.of(2024, 02, 01), prodottiOrdine2, cliente2);
        Order ordine3 = new Order(3, "Disponibile", LocalDate.now(), LocalDate.of(2024, 03, 01), prodottiOrdine3, cliente3);
        Order ordine4 = new Order(4, "Disponibile", LocalDate.now(), LocalDate.of(2024, 05, 01), prodottiOrdine4, cliente3);

        ordini.add(ordine1);
        ordini.add(ordine2);
        ordini.add(ordine3);
        ordini.add(ordine4);

        Stream<Product> streamProdotti = prodotti.stream();
        Stream<Order> streamOrdini = ordini.stream();
        Stream<Customer> streamClieni = clienti.stream();


        System.out.println("ESERCIZIO 1: ");
        Product.filterByCategoryBoys(prodotti).forEach(product -> {});
        System.out.println("ESERCIZIO 2: ");
        Order.filterByCategoryBaby(prodotti);
        System.out.println("ESERCIZIO 3: ");
        Product.filterByCategoryBoys(prodotti).forEach(product -> {});
        System.out.println("ESERCIZIO 4: ");
        Order.filterByDate(ordini);
    }
}
