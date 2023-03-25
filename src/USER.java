import java.util.*;

public class USER {
    private String username;
    private String password;
    private String email;
    private int phoneNumber;
    private String address;
    private List<Product> shoppingCart;
    private List<Product> ordersList;
    private List<Product> purchasedProducts;
    private double wallet = 0.0 ;

    public USER(String username, String password, String email, int phoneNumber, String address,double wallet) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        shoppingCart = new ArrayList<>();
        ordersList = new ArrayList<>();
        purchasedProducts = new ArrayList<>();
        this.wallet = wallet;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setShoppingCart(List<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    public void setOrdersList(List<Product> ordersList) {
        this.ordersList = ordersList;
    }
    public void setPurchasedProducts(List<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public List<Product> getShoppingCart() {
        return shoppingCart;
    }
    public List<Product> getOrdersList() {
        return ordersList;
    }
    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }
    public double getWallet() {
        return wallet;
    }



}
