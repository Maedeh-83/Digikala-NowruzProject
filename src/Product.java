import java.util.*;

public class Product {
    private String name;
    private int price;
    private int quantity;
    private int cartNumber;
    private String additionalData;
    private SELLER seller;
    private int ID;

    public Product(int ID,String name, int price, int quantity, String additionalData, SELLER seller) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.cartNumber = cartNumber;
        this.additionalData = additionalData;
        this.seller = seller;
       // this.seller.setCompanyName(seller);
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

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
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

    public int getCartNumber() {
        return cartNumber;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public SELLER getSeller() {
        return seller;
    }

    public int getID() {
        return ID;
    }
}
