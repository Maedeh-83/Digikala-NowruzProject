import java.util.*;

public class Order {
    private static String date;
    private static List<Product> products;
    private static int totalPrice;
    private static USER buyer;
    private static List<SELLER> sellers;

    public Order(String date ,int totalPrice, USER buyer, List<SELLER> sellers,  List<Product> products) {
        this.date = date;
        this.totalPrice = totalPrice;
        this.buyer = buyer;
        this.sellers = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public static void setDate(String date) {
        Order.date = date;
    }

    public static void setTotalPrice(int totalPrice) {
        Order.totalPrice = totalPrice;
    }

    public static void setBuyer(USER buyer) {
        Order.buyer = buyer;
    }

    public static void setSellers(List<SELLER> sellers) {
        Order.sellers = sellers;
    }

    public static void setProducts(List<Product> products) { Order.products = products; }

    public static String  getDate() {
        return date;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }

    public static void getBuyer() {
        System.out.println(" - buyer: " + buyer.getUsername()+ ", " + buyer.getEmail()+ ", " + buyer.getAddress()+ ", " + buyer.getPhoneNumber());
    }

    public static void getSellers() {
        for(SELLER seller : sellers){
            System.out.println(" - sellers: " + seller.getCompanyName()+ ", ");
        }
    }

    public static void getProducts() {
        for(Product product : products){
            System.out.println(" - products: " + product.getName()+ ", ");
        }
    }
}
