import java.util.*;

public class SELLER {
    private String companyName;
    private String password;
    private static List<Product> availableProducts = new ArrayList<>();
    private double wallet ;
    static boolean authorization = false ;

    public SELLER(String companyName, String password, double wallet) {
        this.companyName = companyName;
        this.password = password;
        this.availableProducts = new ArrayList<>();
        this.wallet = wallet;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public static void addNewProduct(Product product){
        availableProducts.add(product);
    }
     public static void getPermission(){
        if(SELLER.authorization==true){
            System.out.println("Permission allready was granted!");
            Main.sellerPanel();
        }
        if(SELLER.authorization==false) {
            System.out.println("<Getting authorization from an admin>");
            Scanner input = new Scanner(System.in);
            String username;
            String password;
            System.out.println(" ");
            System.out.println("<Admin Login>");
            System.out.println("Enter your username:");
            username = input.nextLine();
            System.out.println("Enter your password:");
            password = input.nextLine();
            for (ADMIN admin : Service.adminsList) {
                if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                    System.out.println("you logged in (:");
                    System.out.println("Do you want to authorize the seller?");
                    System.out.println("1-Yes 2-No");
                    int answer = input.nextInt();
                    if (answer == 1) {
                        SELLER.authorization = true;
                        System.out.println("Permission was granted");
                        Main.sellerPanel();
                    }
                    if (answer == 2) {
                        SELLER.authorization = false;
                        System.out.println("Permission was not granted!");
                        Service.logout();
                    }
                } else {
                    System.out.println("admin not found!");
                    Main.START();
                }
            }
        }
    }
    public static void viewAvailableProducts() {
        for (Product product : availableProducts) {
            System.out.println("name: " + product.getName() + " - price: " + product.getPrice() + " - details: " + product.getAdditionalData() + " - available:" + product.getQuantity());
        }
    }
    public static void addAvailableProduct(Product product){
        availableProducts.add(product);
    }
    public static void addaNewProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("enter your password:");
        String password = input.nextLine();
        for (SELLER seller : Service.getSellersList()) {
            if (seller.getPassword().equals(password)){
                String CN = seller.getCompanyName();
                double W = seller.getWallet();
                SELLER seller1 = new SELLER(CN, password, W);
                System.out.println("enter the new product name:");
                String name = input.nextLine();
                System.out.println("enter the new product price:");
                int price = input.nextInt();
                System.out.println("enter additional data:");
                String additionalData = input.nextLine();
                System.out.println("enter the product quantity:");
                int quantity = input.nextInt();
                System.out.println("enter the product id:");
                int id = input.nextInt();
                Product newProduct = new Product(id, name, price, quantity, additionalData, seller1);
                addAvailableProduct(newProduct);
                System.out.println("Product added successfully...");
            }
            else {System.out.println("seller not found!"); }
        }
    }
    public static void showProfile(String password) {
        for (SELLER seller : Service.getSellersList()) {
            if (seller.getPassword().equals(password)) {
                System.out.println("Company name: " + seller.getCompanyName());
                System.out.println("Password: " + password);
                System.out.println("Wallet: " + seller.getWallet());
                System.out.println("Available products: ");
                viewAvailableProducts();
            }
        }
    }
}
