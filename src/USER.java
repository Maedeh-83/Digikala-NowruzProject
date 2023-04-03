import java.util.*;

public class USER {
    private String username;
    private String password;
    private String email;
    private long phoneNumber;
    private String address;
    private List<Product> shoppingCart;
    private List<Product> ordersList;
    private List<Product> purchasedProducts;
    private long wallet = 0;

    public USER(String username, String password, String email, long phoneNumber, String address, long wallet) {
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

    public void setPhoneNumber(long phoneNumber) {
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

    public void setWallet(long wallet) {
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

    public long getPhoneNumber() {
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

    public static void showProfile(String password) {
        for (USER user : Service.getUsersList()) {
            if (user.getPassword().equals(password)) {
                System.out.println("Username: " + user.getUsername());
                System.out.println("Password: " + password);
                System.out.println("Email: " + user.getEmail());
                System.out.println("Phone number: " + user.getPhoneNumber());
                System.out.println("Address: " + user.getAddress());
            }
        }
    }

    public static void showWallet(String password) {
        for (USER user : Service.getUsersList()) {
            if (user.getPassword().equals(password)) {
                System.out.println("your fund: " + user.getWallet());
            }
        }
    }
}
