import java.util.*;

public class Product {

    private String name;
    private int price;
    private int quantity;
    private List<String> comments;
    private String additionalData;

    public Product(String name, int price, int quantity, String additionalData) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        comments = new ArrayList<>();
        this.additionalData = additionalData;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<String> getComments() {
        return comments;
    }

    public String getAdditionalData() {
        return additionalData;
    }
}
