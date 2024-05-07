import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Order {
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = (List<Product>) products;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public static void filterByCategoryBaby(List<Product> products) {
        products.stream()
                .filter(product -> product.getCategory().equals("baby"))
                .forEach(product -> System.out.println(product));
    }

    public static void filterByDate(List<Order> orders) {
        orders.stream()
                .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2024, 1, 31)) && order.getDeliveryDate().isBefore(LocalDate.of(2024, 4, 2)))
                .filter(order -> order.getCustomer().getTier() == 2)
                .flatMap(order -> order.getProducts().stream())
                .forEach(product -> System.out.println(product));
    }


    @Override
    public String toString() {
        return "ID: " + id + ", Status: " + status + ", OrderDate: " + orderDate + ", LocalDate: " + deliveryDate + ", Prodotto:" + products + ", Customer" + customer;
    }
}
