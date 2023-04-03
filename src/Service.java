import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOError;
import java.util.Properties;

public class Service {
    private static List<USER> usersList = new ArrayList<>();
    static List<ADMIN> adminsList = new ArrayList<>();
    static List<SELLER> sellersList = new ArrayList<>();
    private static List<Product> productsList = new ArrayList<>();
    static List<Category> categoryList = new ArrayList<>();
    private static List<Product> cart = new ArrayList<>();
    private static List<Order> ordersList = new ArrayList<>();
    static Double totalProfit = 0.0;
    Scanner input = new Scanner(System.in);

    public Service() {
        this.cart = new ArrayList<>();
        this.usersList = new ArrayList<>();
        this.adminsList = new ArrayList<>();
        this.sellersList = new ArrayList<>();
        this.productsList = new ArrayList<>();
        this.ordersList = new ArrayList<>();
        this.totalProfit = totalProfit;
        this.categoryList = new ArrayList<>();

    }

    public static List<USER> getUsersList() {
        return usersList;
    }
    public List<ADMIN> getAdminsList() {
        return adminsList;
    }
    public List<SELLER> getSellersList() {
        return sellersList;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public Double getTotalProfit() {
        return totalProfit;
    }

    public static List<Product> getCart() {
        return cart;
    }

    public static void viewUsers() {
        for (USER user : usersList) {
            for (int i = 1; i <= usersList.size(); i++) {
                System.out.println("<" + i + ">");
                System.out.println(user.getUsername());
                System.out.println(user.getPassword());
                System.out.println(user.getEmail());
                System.out.println(user.getAddress());
                System.out.println(user.getPhoneNumber());
                System.out.println(".....................................");
            }
        }
    }

    public static void viewDetailsOfProduct(Product product) {

        System.out.println("--" + product.getID() + "--" + product.getName());
        System.out.println("price: " + product.getPrice());
        System.out.println("data: " + product.getAdditionalData());
        System.out.println("quantity: " + product.getQuantity());
        System.out.println("..............................................");
    }
    public static void viewDetailsOfProduct_forAdmins(Product product) {
        System.out.println("name: " + product.getName());
        System.out.println("price: " + product.getPrice());
        System.out.println("data: " + product.getAdditionalData());
        System.out.println("quantity: " + product.getQuantity());
        System.out.println("..............................................");
    }

    public static void viewCart() {
        for (Product product : cart) {
            System.out.println("name: " + product.getName() + " - price: " + product.getPrice() + " - details: " + product.getAdditionalData() + " - available:" + product.getQuantity());
        }
    }

    public static void removeProduct(Product product) {
        cart.remove(product);
    }

    public static void viewOrdersList() {
        for (Order order : ordersList) {
            System.out.println("date: " + order.getDate());
            Order.getProducts();
            System.out.println(" - total price: " + order.getTotalPrice());
            Order.getBuyer();
            Order.getSellers();
            System.out.println("................................................");
        }
    }

    public static void updateNumberOfProduct(Product product) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the desired number of your product:");
        int answer = input.nextInt();
        if (answer <= product.getQuantity()) {
            product.setCartNumber(answer);
            System.out.println("done");
            Main.userPanel();
        } else {
            System.out.println("More than allowed!");
            Main.userPanel();
        }
    }

    public static String uuid() {
        UUID id = UUID.randomUUID();
        String password = id.toString().substring(0,5);
        return password;
    }
    public static void creatUserAccount() {
        Scanner input = new Scanner(System.in);
        String username;
        String password;
        String email;
        int phoneNumber;
        String address;
        System.out.println("<Creating a new account>");
        System.out.println(" ");
        System.out.println("Enter an username:");
        username = input.nextLine();
        password = uuid();
        System.out.println("your password is : " + password);
        //System.out.println("Enter a password:");
        //password = input.nextLine();
        System.out.println("Enter your email:");
        email = input.nextLine();
        System.out.println("Enter your address:");
        address = input.nextLine();
        System.out.println("Enter your phone number:");
        phoneNumber = input.nextInt();

        USER newAccount = new USER(username, password, email, phoneNumber, address, 0);
        usersList.add(newAccount);
        System.out.println("your account created succefully!");
        Main.userPanel();
    }

    public static void userLogin() {
        Scanner input = new Scanner(System.in);
        String mainUsername;
        String mainPassword;
        System.out.println("<User Login>");
        System.out.println(" ");
        System.out.println("Enter your username:");
        mainUsername = input.nextLine();
        System.out.println("Enter your password:");
        mainPassword = input.nextLine();
        for (USER mainUser : usersList) {
            if (mainUser.getUsername().equals(mainUsername) && mainUser.getPassword().equals(mainPassword)) {
                System.out.println("you logged in (:");
                Main.userPanel();
            }
            else {
                System.out.println("user not found!");
                Main.START();
            }
        }
    }

    public static void adminLogin() {
        Scanner input = new Scanner(System.in);
        String username;
        String password;
        System.out.println("<Admin Login>");
        System.out.println(" ");
        System.out.println("Enter your username:");
        username = input.nextLine();
        System.out.println("Enter your password:");
        password = input.nextLine();
        for (ADMIN admin : adminsList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                System.out.println("you logged in (:");
                Main.adminPanel();
            }
            else {
                System.out.println("admin not found!");
                Main.START();
            }
        }
    }

    public static void sellerLogin() {
        Scanner input = new Scanner(System.in);
        String companyName;
        String password;
        System.out.println("Enter your company Name:");
        companyName = input.nextLine();
        System.out.println("Enter your password:");
        password = input.next();
        for (SELLER seller : sellersList) {
            if (seller.getCompanyName().equals(companyName) && seller.getPassword().equals(password)) {
                if(seller.authorization == true){
                    Main.sellerPanel();
                }
                if(seller.authorization == false){
                    System.out.println("Permission was not granted!");
                    Main.START();
                }
            }
            else {
                System.out.println("seller not found!");
            }
        }
    }

    public static void editPersonalInformation() {
        Scanner input = new Scanner(System.in);
        System.out.println("first, enter your current username and password...");
        System.out.println("current username:");
        String currentUsername = input.nextLine();
        System.out.println("current password:");
        String currentPassword = input.nextLine();
        System.out.println("ok!");
        System.out.println("What do you want to edit?");
        System.out.println("1-username");
        System.out.println("2-password");
        System.out.println("3-email");
        System.out.println("4-phone number");
        System.out.println("5-address");
        int answer = input.nextInt();

        switch (answer) {
            case 1:
                System.out.println("Enter your new username:");
                String newUsername = input.next();
                for (USER user : usersList) {
                    if (user.getUsername().equals(currentUsername)) {
                        user.setUsername(newUsername);
                        System.out.println("Username has been successfully updated..");
                        Main.userPanel();
                    }
                }
                break;

            case 2:
                System.out.println("Enter your new password:");
                String newPassword = input.next();
                for (USER user : usersList) {
                    if (user.getPassword().equals(currentPassword)) {
                        user.setUsername(newPassword);
                        System.out.println("Password has been successfully updated..");
                        Main.userPanel();
                    }
                }
                break;


            case 3:
                System.out.println("Enter your new email:");
                String newEmail = input.next();
                for (USER user : usersList) {
                    if (user.getUsername().equals(currentUsername) && user.getPassword().equals(currentPassword)) {
                        user.setEmail(newEmail);
                        System.out.println("Email has been successfully updated..");
                        Main.userPanel();
                    }
                }
                break;

            case 4:
                System.out.println("Enter your new phone number:");
                long newPhoneNumber = input.nextLong();
                for (USER user : usersList) {
                    if (user.getUsername().equals(currentUsername) && user.getPassword().equals(currentPassword)) {
                        user.setPhoneNumber(newPhoneNumber);
                        System.out.println("PhoneNumber has been successfully updated..");
                        Main.userPanel();
                    }
                }
                break;

            case 5:
                System.out.println(" ");
                String x = input.nextLine();
                System.out.println("Enter your new address:");
                String newAddress = input.nextLine();
                for (USER user : usersList) {
                    if (user.getUsername().equals(currentUsername) && user.getPassword().equals(currentPassword)) {
                        user.setAddress(newAddress);
                        System.out.println("Address has been successfully updated..");
                        Main.userPanel();
                    }
                }
                break;
        }
    }

    public static void creatAdminAccount() {            //just by another admin
        Scanner input = new Scanner(System.in);
        String username;
        String password;
        String email;
        System.out.println("<Creating a new admin account>");
        System.out.println(" ");
        System.out.println("Enter an username:");
        username = input.nextLine();
        System.out.println("Enter a password:");
        password = input.nextLine();
        System.out.println("Enter an email:");
        email = input.nextLine();

        ADMIN newAdmin = new ADMIN(username, password, email);
        adminsList.add(newAdmin);
        System.out.println("a new admin account created succefully!");

    }

    public static ArrayList<Product> search(String title) {
        ArrayList<Product> found = new ArrayList<>();
        for (Product product : productsList) {
            if (product.getName().contains(title)) {
                found.add(product);
            }
        }
        return found;
    }

    public static void addToCart(Product product) {
        cart.add(product);
    }

    public static void logout() {
        Main.START();
    }

    public static void orderSubmission(List<Product> cart) {
        // ابتدا چک کردن موجودی کیف پول کاربر
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = input.nextLine();
        System.out.println("Enter your password:");
        String password = input.nextLine();
        USER buyer = null;
        for (USER user : usersList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                buyer = new USER(username, password, user.getEmail(), user.getPhoneNumber(), user.getAddress(), (long) user.getWallet());
            }
        }
        ArrayList<SELLER> sellerss = new ArrayList<>();
        for (Product product : cart) {
            sellerss.add(product.getSeller());
        }
        System.out.println("Enter today's date:");
        String date = input.nextLine();
        int totalPrice = 0;
        for (Product product : cart) {
            totalPrice = totalPrice + product.getPrice();
        }
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : cart) {
            products.add(product);
        }

        if (buyer.getWallet() >= totalPrice) {
            // 1-سفارش دادن سبد خرید
            Order order = new Order(date, totalPrice, buyer, sellerss, products);
            ordersList.add(order);
            // 2-آپدیت شدن موجودی محصولات
            for (Product product : cart) {
                int newQuantity = product.getQuantity() - product.getCartNumber();
                product.setQuantity(newQuantity);
            }
            // 3-کم شدن پول از کیف پول کاربر و افزوده شدن به کیف پول فروشنده و سود دیجی کالا
            long newWallet = (long) (buyer.getWallet() - totalPrice);
            buyer.setWallet(newWallet);

            totalProfit = totalProfit + (0.1 * totalPrice);

            for (Product product : cart) {
                for(SELLER seller : sellersList) {
                    if(seller.getCompanyName().equals(product.getSeller().getCompanyName())) {
                        seller.setWallet(0.9 * product.getPrice());

                       // product.getSeller().setWallet(0.9 * product.getPrice());
                    }
                }
            }

            System.out.println("The order was successfully placed (: ");
        } else {
            System.out.println("you don’t have enough funds in your wallet, so the order was canceled!");
        }
    }

    public static void increaseWalletFund() {
        System.out.println("<send a request to the admins for adding funds>");
        Scanner input = new Scanner(System.in);
        String username1;
        String password1;
        System.out.println(" ");
        System.out.println("Enter your username:");
        username1 = input.nextLine();
        System.out.println("Enter your password:");
        password1 = input.nextLine();
        System.out.println("How much fund do you want to add to your wallet?");
        double fund = input.nextInt();
        System.out.println("Your requested fund : " + fund);
        System.out.println(" ");
        System.out.println("<Admin Login>");
        System.out.println("Enter your username:");
        String username2 = input.next();
        System.out.println("Enter your password:");
        String password2 = input.next();
        for (ADMIN admin : Service.adminsList) {
            if (admin.getUsername().equals(username2) && admin.getPassword().equals(password2)) {
                System.out.println("you logged in (:");
                System.out.println("Do you want to add " + fund + " to this user wallet?");
                System.out.println("1-Yes  2-No");
                int answer = input.nextInt();
                if(answer==1){
                    for(USER user : usersList){
                        if(user.getUsername().equals(username1) && user.getPassword().equals(password1)) {
                            long newWallet = (long) (user.getWallet() + fund);
                            user.setWallet(newWallet);
                            System.out.println("The request was approved");
                            Main.userPanel();
                        }
                        else {
                            System.out.println("user not found!");
                            Main.userPanel();
                        }
                    }
                }
                if(answer==2){
                    System.out.println("The request was not approved!");
                    Main.userPanel();
                }
            }
            else {
                System.out.println("admin not found!");
                Main.userPanel();
            }
        }
    }

    public static void addCategory(Category category){
        categoryList.add(category);
    }
    public static void addUser(USER user){
        usersList.add(user);
    }
    public static void addAdmin(ADMIN admin){
        adminsList.add(admin);
    }
    public static void addToProductsList(Product product){
        productsList.add(product);
    }



}


