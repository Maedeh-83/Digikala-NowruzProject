import java.util.*;

public class SELLER {

    private String companyName;
    private String password;
    private List<Product> availableProducts;
    private double wallet = 0.0 ;

    public SELLER(String companyName, String password, double wallet) {
        this.companyName = companyName;
        this.password = password;
        availableProducts = new ArrayList<>();
        this.wallet = wallet;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvailableProducts(List<Product> availableProducts) {
        this.availableProducts = availableProducts;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPassword() {
        return password;
    }

    public List<Product> getAvailableProducts() {
        return availableProducts;
    }

    public double getWallet() {
        return wallet;
    }
}
