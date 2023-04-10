import java.util.*;
import java.io.FileOutputStream;
import java.io.IOError;
import java.util.Properties;

public class Main {

    private static Category womenCloths = new Category("1-womenCloths");
    private static Category menCloths = new Category("2-Men Cloths");
    private static Category kidCloths = new Category("3-Kid Cloths");
    private static Category makeUp = new Category("1-Makeup");
    private static Category skinCare = new Category("2-Skin care");
    private static Category hairCare = new Category("3-Hair care");
    private static Category cellPhones = new Category("1-Cell Phones");
    private static Category laptops = new Category("2-Laptops");
    private static Category smartWatches = new Category("3-Smart watches");
    private static Category headphones = new Category("4-Headphones");
    private static Category electricHouseholdAppliances = new Category("1-Electric household appliances");
    private static Category kitchenUtensils = new Category("2-Kitchen Utensils");
    private static Category bedding = new Category("3-bedding");
    private static Category book = new Category("1-Book");
    private static Category notrbookAndpaper = new Category("2-Notebook & Paper");
    private static Category backpack = new Category("3-backpack");

    public static void START() {
        Scanner input = new Scanner(System.in);
        System.out.println(".......................Digikala.......................");
        System.out.println(" ");
        System.out.println("please select wheter you are an user or an admin or a seller?");
        System.out.println("1-user             2-admin             3-seller");
        int role = input.nextInt();
        switch (role) {
            case 1 :
                System.out.println("1) Sign in         2) Sign up");
                int ans = input.nextInt();
                if(ans == 1) {
                    Service.userLogin();
                }
                if(ans == 2) {
                    Service.creatUserAccount();
                }
                break;

            case 2 :
                Service.adminLogin();
                break;

            case 3 :
                Service.sellerLogin1();
               /* System.out.println("Have you allready Get authorization from an admin?");
                System.out.println("1-Yes     2-No");
                int ans1 = input.nextInt();
                if(ans1 == 1){ Service.sellerLogin(); }
                if(ans1 == 2){ SELLER.getPermission(); }
                */
                break;

            default:
                System.out.println("Wrong Input!");
        }
    }

    public static void userPanel() {

        Scanner input = new Scanner(System.in);
        System.out.println("*Enter your desired option:");
        System.out.println("------------------------------");
        System.out.println("1.Profile");
        System.out.println("2.Wallet");
        System.out.println("3.Categories");
        System.out.println("4.Search");
        System.out.println("5.Cart");
        System.out.println("6.Orders");
        System.out.println("7.Contact us");
        System.out.println("8.Logout");

        int option = input.nextInt();

        switch (option) {

            case 1 :   //prifile
                System.out.println("Enter your password:");
                String password = input.next();
                USER.showProfile(password);
                System.out.println("..............................");
                System.out.println("1-Edit personal information");
                System.out.println("2-BACK");
                int ans = input.nextInt();
                if(ans == 1){ Service.editPersonalInformation(); }
                if(ans == 2){
                    System.out.println("..............................");
                    userPanel();
                }
                break;

            case 2 :
               // USER.showWallet();
                System.out.println("Enter your password:");
                String password1 = input.next();
                USER.showWallet(password1);
                System.out.println("..............................");
                System.out.println("1-Increase wallet fund");
                System.out.println("2-BACK");
                int ans1 = input.nextInt();
                if(ans1 == 1){ Service.increaseWalletFund(); }
                if(ans1 == 2){
                    System.out.println("..............................");
                    userPanel();
                }

                break;

            case 3 :
                for(Category category : Service.categoryList) {
                        System.out.println(category.getName());
                }
                System.out.println("6-BACK");
                System.out.println("------------------------------");
                System.out.println("<Enter your desired category>");
                int category = input.nextInt();

                switch (category) {
                    case 1 :
                        System.out.println("1-Women Cloths");
                        System.out.println("2-Men Cloths");
                        System.out.println("3-Kid Cloths");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub1 = input.nextInt();

                        if(sub1 == 1){
                        for(Product product : womenCloths.getProducts()){
                            Service.viewDetailsOfProduct(product);
                            }
                        System.out.println("Do you want to add a product to your shopping cart?");
                        System.out.println("1-YES  2-BACK");
                        int choise = input.nextInt();
                        if(choise == 1){
                            System.out.println("Enter the product number that you want to add to your shopping cart :");
                            int num = input.nextInt();
                            if(num == 1) {
                                System.out.println("How many of this product do you want to add to the shopping cart?");
                                int cartNum = input.nextInt();
                                for (Product product : womenCloths.getProducts()) {
                                    if(product.getID() == 1) {
                                        Service.addToCart(product);
                                        product.setCartNumber(cartNum);
                                    }
                                }
                                System.out.println("The product has been added to the shopping cart (:");
                                System.out.println("-----------------------------------------");
                                System.out.println("1-view cart    2-BACK");
                                int anss = input.nextInt();
                                if(anss == 1){
                                    Service.viewCart();
                                    userPanel();
                                }
                                if(anss == 2){ userPanel(); }

                            }
                            if(num == 2) {
                                System.out.println("How many of this product do you want to add to the shopping cart?");
                                int cartNum = input.nextInt();
                                for (Product product : womenCloths.getProducts()) {
                                    if(product.getID() == 2) {
                                        Service.addToCart(product);
                                        product.setCartNumber(cartNum);
                                    }
                                }
                                System.out.println("The product has been added to the shopping cart (:");
                                System.out.println("-----------------------------------------");
                                System.out.println("1-view cart    2-BACK");
                                int anss = input.nextInt();
                                if(anss == 1){
                                    Service.viewCart();
                                    userPanel();
                                }
                                if(anss == 2){ userPanel(); }
                            }
                            if(num == 3) {
                                System.out.println("How many of this product do you want to add to the shopping cart?");
                                int cartNum = input.nextInt();
                                for (Product product : womenCloths.getProducts()) {
                                    if(product.getID() == 3) {
                                        Service.addToCart(product);
                                        product.setCartNumber(cartNum);
                                    }
                                }
                                System.out.println("The product has been added to the shopping cart (:");
                                System.out.println("-----------------------------------------");
                                System.out.println("1-view cart    2-BACK");
                                int anss = input.nextInt();
                                if(anss == 1){
                                    Service.viewCart();
                                    userPanel();
                                }
                                if(anss == 2){ userPanel(); }
                            }
                        }
                        if(choise == 2){ userPanel(); }
                        }

                        if(sub1 == 2){
                            for(Product product : menCloths.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : menCloths.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }

                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : menCloths.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }

                        if(sub1 == 3){
                            for(Product product : kidCloths.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add this product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("How many of this product do you want to add to the shopping cart?");
                                int cartNum = input.nextInt();
                                for (Product product : kidCloths.getProducts()) {
                                    if(product.getID() == 1) {
                                        Service.addToCart(product);
                                        product.setCartNumber(cartNum);
                                    }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                            }
                            if(choise == 2){ userPanel(); }
                        }
                        break;

                    case 2 :
                        System.out.println("1-Makeup");
                        System.out.println("2-Skin care");
                        System.out.println("3-Hair care");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub2 = input.nextInt();
                        if(sub2 == 1){
                            for(Product product : makeUp.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : makeUp.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : makeUp.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }

                        if(sub2 == 2){
                            for(Product product : skinCare.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : skinCare.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }

                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : skinCare.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }
                        if(sub2 == 3){
                            for(Product product : hairCare.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : hairCare.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : hairCare.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }
                        break;

                    case 3 :
                        System.out.println("1-Cell Phones");
                        System.out.println("2-Laptops");
                        System.out.println("3-Smart watches");
                        System.out.println("4-Headphones");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub3 = input.nextInt();
                        if(sub3== 1){
                            for(Product product : cellPhones.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : cellPhones.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : cellPhones.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 3) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : cellPhones.getProducts()) {
                                        if(product.getID() == 3) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 4) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : cellPhones.getProducts()) {
                                        if(product.getID() == 4) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }
                        if(sub3 == 2){
                            for(Product product : laptops.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : laptops.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : laptops.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 3) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : laptops.getProducts()) {
                                        if(product.getID() == 3) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }
                        if(sub3 == 3){
                            for(Product product : smartWatches.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : smartWatches.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : smartWatches.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }
                        if(sub3 == 4){
                            for(Product product : headphones.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : headphones.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : headphones.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 3) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : headphones.getProducts()) {
                                        if(product.getID() == 3) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }
                        break;

                    case 4 :
                        System.out.println("1-Electric household appliances");
                        System.out.println("2-Kitchen Utensils");
                        System.out.println("3-bedding");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub4 = input.nextInt();
                        if(sub4 == 1){
                            for(Product product : electricHouseholdAppliances.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : electricHouseholdAppliances.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : electricHouseholdAppliances.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }
                        if(sub4 == 2){
                            for(Product product : kitchenUtensils.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : kitchenUtensils.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : kitchenUtensils.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }
                        if(sub4 == 3){
                            for(Product product : bedding.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : bedding.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : bedding.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }
                        break;

                    case 5 :
                        System.out.println("1-Book");
                        System.out.println("2-Notebook & Paper");
                        System.out.println("3-backpack");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub5 = input.nextInt();

                        if(sub5 == 1){
                            for(Product product : book.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : book.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : book.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                                if(num == 3) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : book.getProducts()) {
                                        if(product.getID() == 3) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }

                        if(sub5 == 2){
                            System.out.println("There are no products available!");
                            userPanel();
                        }

                        if(sub5 == 3){
                            for(Product product : backpack.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("Do you want to add a product to your shopping cart?");
                            System.out.println("1-YES  2-BACK");
                            int choise = input.nextInt();
                            if(choise == 1){
                                System.out.println("Enter the product number that you want to add to your shopping cart :");
                                int num = input.nextInt();
                                if(num == 1) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : backpack.getProducts()) {
                                        if(product.getID() == 1) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }

                                }
                                if(num == 2) {
                                    System.out.println("How many of this product do you want to add to the shopping cart?");
                                    int cartNum = input.nextInt();
                                    for (Product product : backpack.getProducts()) {
                                        if(product.getID() == 2) {
                                            Service.addToCart(product);
                                            product.setCartNumber(cartNum);
                                        }
                                    }
                                    System.out.println("The product has been added to the shopping cart (:");
                                    System.out.println("-----------------------------------------");
                                    System.out.println("1-view cart    2-BACK");
                                    int anss = input.nextInt();
                                    if(anss == 1){
                                        Service.viewCart();
                                        userPanel();
                                    }
                                    if(anss == 2){ userPanel(); }
                                }
                            }
                            if(choise == 2){ userPanel(); }
                        }
                        break;

                    case 6 :
                        userPanel();
                        break;
                }
                break;

            case 4 :     //search
                System.out.println("<search by title>");
                System.out.println("Enter product name:");
                String name = input.next();
                ArrayList<Product> result = Service.search(name);
                for(Product product : result){
                    System.out.println(product.getName());
                    System.out.println("price: " + product.getPrice());
                    System.out.println("data: " + product.getAdditionalData());
                    System.out.println("quantity: " + product.getQuantity());
                    System.out.println("..............................................");
                }
                System.out.println("Do you want to add this product to your shopping cart?   1-YES   2-NO");
                int answer = input.nextInt();
                if(answer == 1){
                    for(Product product : result){
                        Service.addToCart(product);
                    }
                    System.out.println("The product has been added to the shopping cart (:");
                    System.out.println("-----------------------------------------");
                    System.out.println("1-view cart    2-BACK");
                    int anss = input.nextInt();
                    if(anss == 1){
                        Service.viewCart();
                        System.out.println("--------------------------------------------");
                        userPanel();
                    }
                    if(anss == 2){ userPanel(); }
                }
                if(answer == 2){
                    userPanel();
                }
                break;

            case 5 :    //cart
                Service.viewCart();
                System.out.println("-----------------------------------------");
                System.out.println("Do you want to order your shopping cart?    1-YES    2-NO");
                int anss = input.nextInt();
                if(anss == 1){
                    Service.orderSubmission(Service.getCart());
                    Service.viewOrdersList();
                    userPanel();
                }
                if(anss == 2){ userPanel(); }

                break;

            case 6 :   //orders
                Service.viewOrdersList();
                userPanel();
                break;

            case 7 :
                System.out.println("Contact number for support :  09146566930");
                userPanel();

                break;

            case 8 :   //logout
                START();
                break;
        }
    }

    public static void adminPanel() {
        Scanner input = new Scanner(System.in);
        System.out.println("*Enter your desired option:");
        System.out.println("------------------------------");
        System.out.println("1.Profile");
        System.out.println("2.Store Wallet");
        System.out.println("3.Add a new admin");
        System.out.println("4.Search");
        System.out.println("5.View users");
        System.out.println("6.View the list of Categories with products");
        System.out.println("7.View the Orders");
        System.out.println("8.Logout");

        int option = input.nextInt();

        switch (option) {

            case 1 :    //profile
                System.out.println("Enter your password:");
                String password = input.next();
                ADMIN.showProfile(password);
                System.out.println("..............................");
                System.out.println("1-BACK");
                int ans = input.nextInt();
                if(ans == 1){
                    System.out.println("..............................");
                    adminPanel();
                }
                break;

            case 2 :
                System.out.println("TotalProfit:  " + Service.totalProfit);
                System.out.println("----------------------------------");
                adminPanel();
                break;

            case 3 :  //Add a new admin
                Service.creatAdminAccount();
                adminPanel();
                break;

            case 4 :    //search
                System.out.println("1)search products");
                System.out.println("2)search users");
                int ans1 = input.nextInt();
                if(ans1 == 1) {
                    System.out.println("<search by title>");
                    System.out.println("Enter product name:");
                    String name = input.next();
                    ArrayList<Product> result = Service.search(name);
                    for (Product product : result) {
                        System.out.println(product.getName());
                        System.out.println("price: " + product.getPrice());
                        System.out.println("data: " + product.getAdditionalData());
                        System.out.println("quantity: " + product.getQuantity());
                        System.out.println("..............................................");
                    }
                    adminPanel();
                }
                    if(ans1 == 2){
                        System.out.println("Enter a username:");
                        String username = input.next();
                        ArrayList<USER> result1 = Service.searchUser(username);
                        for(USER user : result1){
                            System.out.println(user.getUsername());
                            System.out.println("password: " + user.getPassword());
                            System.out.println("wallet: " + user.getWallet());
                            System.out.println("phoneNumber: " + user.getPhoneNumber());
                            System.out.println("email: " + user.getEmail());
                            System.out.println("address: " + user.getAddress());
                            System.out.println("..............................................");
                        }
                        adminPanel();
                    }
                break;

            case 5 :     //viewUsers
                Service.viewUsers();
                adminPanel();
                break;

            case 6 :        //categories
                for(Category category : Service.categoryList) {
                    System.out.println(category.getName());
                }
                System.out.println("6-BACK");
                System.out.println("------------------------------");
                System.out.println("<Enter your desired category>");
                int category = input.nextInt();

                switch (category) {
                    case 1 :
                        System.out.println("1-Women Cloths");
                        System.out.println("2-Men Cloths");
                        System.out.println("3-Kid Cloths");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub1 = input.nextInt();

                        if(sub1 == 1){
                            for(Product product : womenCloths.getProducts()){
                                Service.viewDetailsOfProduct_forAdmins(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }

                        if(sub1 == 2){
                            for(Product product : menCloths.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }

                        if(sub1 == 3) {
                            for(Product product : kidCloths.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }
                        break;

                    case 2 :
                        System.out.println("1-Makeup");
                        System.out.println("2-Skin care");
                        System.out.println("3-Hair care");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub2 = input.nextInt();
                        if(sub2 == 1){
                            for(Product product : makeUp.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }

                        if(sub2 == 2){
                            for(Product product : skinCare.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }
                        if(sub2 == 3){
                            for(Product product : hairCare.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }
                        break;

                    case 3 :
                        System.out.println("1-Cell Phones");
                        System.out.println("2-Laptops");
                        System.out.println("3-Smart watches");
                        System.out.println("4-Headphones");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub3 = input.nextInt();
                        if(sub3== 1){
                            for(Product product : cellPhones.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }
                        if(sub3 == 2){
                            for(Product product : laptops.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }
                        if(sub3 == 3){
                            for(Product product : smartWatches.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }
                        if(sub3 == 4){
                            for(Product product : headphones.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }
                        break;

                    case 4 :
                        System.out.println("1-Electric household appliances");
                        System.out.println("2-Kitchen Utensils");
                        System.out.println("3-bedding");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub4 = input.nextInt();
                        if(sub4 == 1){
                            for(Product product : electricHouseholdAppliances.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }
                        if(sub4 == 2){
                            for(Product product : kitchenUtensils.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }
                        if(sub4 == 3){
                            for(Product product : bedding.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }
                        break;

                    case 5 :
                        System.out.println("1-Book");
                        System.out.println("2-Notebook & Paper");
                        System.out.println("3-backpack");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub5 = input.nextInt();

                        if(sub5 == 1){
                            for(Product product : book.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }

                        if(sub5 == 2){
                            System.out.println("There are no products available!");
                           adminPanel();
                        }

                        if(sub5 == 3){
                            for(Product product : backpack.getProducts()){
                                Service.viewDetailsOfProduct(product);
                            }
                            System.out.println("1-BACK");
                            int back = input.nextInt();
                            if(back == 1 ){ adminPanel(); }
                        }
                        break;

                    case 6 :
                        adminPanel();
                        break;
                }
                break;

            case 7 :
                Service.viewOrdersList();
                adminPanel();
                break;

            case 8 :
                START();
                break;
        }
    }

    public static void sellerPanel() {
        Scanner input = new Scanner(System.in);
        System.out.println("*Enter your desired option:");
        System.out.println("------------------------------");
        System.out.println("1.Profile");
        System.out.println("2.View available products");
        System.out.println("3.Add a new product");
        System.out.println("4.Getting authorization from an admin");
        System.out.println("5.Logout");

        int option = input.nextInt();

        switch (option) {
            case 1 :    //profile
                System.out.println("Enter your password:");
                String password = input.next();
                SELLER.showProfile(password);
                System.out.println("..............................");
                System.out.println("1-BACK");
                int ans = input.nextInt();
                if(ans == 1){
                    System.out.println("..............................");
                    sellerPanel();
                }
                break;

            case 2 :    //View available products
                SELLER.viewAvailableProducts();
                sellerPanel();
                break;

            case 3 :    //add a New Product
                SELLER.addaNewProduct();
                sellerPanel();
                break;

            case 4 :     //get permission
                SELLER.getPermission();
                break;

            case 5 :
                START();
                break;
        }
    }

    public static void main(String[] args) {

        Category modAndCloths = new Category("1***Mod And Cloths");
        //Category womenCloths = new Category("1-Women Cloths");
        //Category menCloths = new Category("2-Men Cloths");
        //Category kidCloths = new Category("3-Kid Cloths");
        Category beautyAndPersonalCare = new Category("2***Beauty And Personal Care");
        //Category makeUp = new Category("1-Makeup");
        //Category skinCare = new Category("2-Skin care");
        //Category hairCare = new Category("3-Hair care");
        Category electronics = new Category("3***Electronics");
        //Category cellPhones = new Category("1-Cell Phones");
        //Category laptops = new Category("2-Laptops");
        //Category smartWatches = new Category("3-Smart watches");
        //Category headphones = new Category("4-Headphones");
        Category homeAndKitchen = new Category("4***Home And Kitchen");
        //Category electricHouseholdAppliances = new Category("1-Electric household appliances");
        //Category kitchenUtensils = new Category("2-Kitchen Utensils");
        //Category bedding = new Category("3-bedding");
        Category booksAndStationery = new Category("5***Books & Stationery");
        //Category book = new Category("1-Book");
        //Category notrbookAndpaper = new Category("2-Notebook & Paper");
        //Category backpack = new Category("3-backpack");

        SELLER Gostaresh = new SELLER("Gostaresh","Gostaresh", 0.0);
        SELLER Sam_ram = new SELLER("Sam_ram","Sam_ram", 0.0);
        SELLER Karzin_plus = new SELLER("Karzin_plus","Karzin_plus", 0.0);
        SELLER Pardazeshgar = new SELLER("Pardazeshgar","Pardazeshgar", 0.0);
        SELLER Avazhang = new SELLER("Avazhang","Avazhang", 0.0);
        SELLER Pardis_store = new SELLER("Pardis_store","Pardis_store", 0.0);
        SELLER Pershia = new SELLER("Pershia","Pershia", 0.0);
        SELLER Kasra = new SELLER("Kasra","Kasra", 0.0);
        SELLER Baycal = new SELLER("Baycal","Baycal", 0.0);
        SELLER Ravin = new SELLER("Ravin","Ravin", 0.0);
        SELLER Rayatak = new SELLER("Rayatak","Rayatak", 0.0);
        SELLER Wrangler = new SELLER("Wrangler","Wrangler", 0.0);
        SELLER Drop = new SELLER("Drop","Drop", 0.0);
        SELLER FROGG_TOGGS = new SELLER("FROGG_TOGGS","FROGG_TOGGS", 0.0);
        SELLER Stride_Rite360 = new SELLER("Stride_Rite360","Stride_Rite360", 0.0);
        SELLER Scholastic_Inc = new SELLER("Scholastic_Inc","Scholastic_Inc", 0.0);
        SELLER Ketabkala = new SELLER("Ketabkala","Ketabkala", 0.0);
        SELLER Carhartt_Unisex = new SELLER("Carhartt_Unisex","Carhartt_Unisex", 0.0);
        SELLER McCulloch_Store = new SELLER("McCulloch_Store","McCulloch_Store", 0.0);
        SELLER VIZIO = new SELLER("VIZIO","VIZIO", 0.0);
        SELLER Keurig = new SELLER("Keurig","Keurig", 0.0);
        SELLER Aroma = new SELLER("Aroma","Aroma", 0.0);
        SELLER Lucid = new SELLER("Lucid","Lucid", 0.0);
        SELLER Acanva = new SELLER("Acanva","Acanva", 0.0);
        SELLER stila = new SELLER("stila","stila", 0.0);
        SELLER Maybelline = new SELLER("Maybelline","Maybelline", 0.0);
        SELLER CeraVe = new SELLER("CeraVe","CeraVe", 0.0);
        SELLER Vanicream = new SELLER("Vanicream","Vanicream", 0.0);
        SELLER Anthony = new SELLER("Anthony","Anthony", 0.0);
        SELLER Conair = new SELLER("Conair","Conair", 0.0);
        SELLER Dickies = new SELLER("Dickies","Dickies", 0.0);

        Service.addSeller(Dickies);
        Service.addSeller(FROGG_TOGGS);
        Service.addSeller(McCulloch_Store);
        Service.addSeller(Drop);
        Service.addSeller(Gostaresh);
        Service.addSeller(Sam_ram);
        Service.addSeller(Scholastic_Inc);
        Service.addSeller(Stride_Rite360);
        Service.addSeller(Vanicream);
        Service.addSeller(Conair);
        Service.addSeller(VIZIO);
        Service.addSeller(Anthony);
        Service.addSeller(Acanva);
        Service.addSeller(Aroma);
        Service.addSeller(Avazhang);
        Service.addSeller(Lucid);
        Service.addSeller(Keurig);
        Service.addSeller(Kasra);
        Service.addSeller(Karzin_plus);
        Service.addSeller(Ketabkala);
        Service.addSeller(Rayatak);
        Service.addSeller(Ravin);
        Service.addSeller(Pardazeshgar);
        Service.addSeller(Wrangler);
        Service.addSeller(Carhartt_Unisex);
        Service.addSeller(CeraVe);
        Service.addSeller(Maybelline);
        Service.addSeller(Baycal);
        Service.addSeller(Pershia);
        Service.addSeller(Pardis_store);
        Service.addSeller(stila);

        modAndCloths.addSubCategories(womenCloths);
        modAndCloths.addSubCategories(menCloths);
        modAndCloths.addSubCategories(kidCloths);
        beautyAndPersonalCare.addSubCategories(makeUp);
        beautyAndPersonalCare.addSubCategories(skinCare);
        beautyAndPersonalCare.addSubCategories(hairCare);
        electronics.addSubCategories(cellPhones);
        electronics.addSubCategories(laptops);
        electronics.addSubCategories(smartWatches);
        electronics.addSubCategories(headphones);
        homeAndKitchen.addSubCategories(electricHouseholdAppliances);
        homeAndKitchen.addSubCategories(kitchenUtensils);
        homeAndKitchen.addSubCategories(bedding);
        booksAndStationery.addSubCategories(book);
        booksAndStationery.addSubCategories(notrbookAndpaper);
        booksAndStationery.addSubCategories(backpack);

        Service.addCategory(modAndCloths);
        Service.addCategory(beautyAndPersonalCare);
        Service.addCategory(electronics);
        Service.addCategory(homeAndKitchen);
        Service.addCategory(booksAndStationery);

        Product cellPhone1 = new Product( 1,"Samsung Galaxy A53", 15800000, 1, "5G, Android 12, 6.46 inch, Ram 8, Memory 256G", Gostaresh);
        Product cellPhone2 = new Product(2,"Samsung Galaxy Z Flip3", 35000000, 13, "5G, Android 11, 6.7 inch, Ram 8, Memory 256G", Sam_ram);
        Product cellPhone3 = new Product(3,"iPhone 13 CH", 45000000, 3, "5G, ios 15, 6.1 inch, Ram 4, Memory 128G", Karzin_plus);
        Product cellPhone4 = new Product(4,"Xiaomi Poco X4 Pro", 12000000, 20, "5G, Android 11, 6.67 inch, Ram 6, Memory 128G", Pardazeshgar);

        Gostaresh.addAvailableProduct(cellPhone1);
        Sam_ram.addAvailableProduct(cellPhone2);
        Karzin_plus.addAvailableProduct(cellPhone3);
        Pardazeshgar.addAvailableProduct(cellPhone4);

        cellPhones.addProduct(cellPhone1);
        cellPhones.addProduct(cellPhone2);
        cellPhones.addProduct(cellPhone3);
        cellPhones.addProduct(cellPhone4);

        Product laptop1 = new Product(1,"Asus vivobook S14", 36000000, 7, "Ryzen 5, Ram 8, Memory 1T, 14 inch", Avazhang);
        Product laptop2 = new Product(2,"Asus ZenBook 14 UX435EG-B", 59000000, 2, "Core i5, Ram 8, Memory 512G, 14 inch", Pardis_store);
        Product laptop3 = new Product(3,"Apple MacBook M2 LLA", 65500000, 4, "M2, Ram 8, Memory 256G", Pershia);

        Avazhang.addAvailableProduct(laptop1);
        Pardis_store.addAvailableProduct(laptop2);
        Pershia.addAvailableProduct(laptop3);

        laptops.addProduct(laptop1);
        laptops.addProduct(laptop2);
        laptops.addProduct(laptop3);

        Product smartWatch1 = new Product(1,"Samsung Galaxy Watch4", 6900000, 18, "Weight 30g, form:circular, 1.4 inch", Kasra);
        Product smartWatch2 = new Product(2,"Xiaomi Redmi Watch 2 Lite", 2400000, 12, "Weight 350g, form:rectangular, 1.7 inch", Baycal);

        smartWatches.addProduct(smartWatch1);
        smartWatches.addProduct(smartWatch2);

        Product headphone1 = new Product(1,"QCY T13 TWS", 700000, 6, "Weight 20g, battery 8h, bluetooth 5.1, Access diameter: 10m", Ravin);
        Product headphone2 = new Product(2,"Leitu LT-13", 995000, 2, "Weight 32g, battery 4h, bluetooth 5.1, Access diameter: 10m", Ravin);
        Product headphone3 = new Product(3,"Samsung Galaxy Buds2 Pro", 6800000, 11, "Weight 27g, battery 18h, bluetooth 5.1, Access diameter: 15m", Rayatak);

        headphones.addProduct(headphone1);
        headphones.addProduct(headphone2);
        headphones.addProduct(headphone3);

        Product womenCloth1 = new Product(1,"Women's Stretch Denim Jacket", 1800000, 33, "99% Cotton, Button closure, color: blue", Wrangler);
        Product womenCloth2 = new Product(2,"Women's Noa Trench Coat", 3000000, 17, "64% Cotton-36% Nylon, Cotton lining,Pull On closure,Machine Wash", Drop);
        Product womenCloth3 = new Product(3,"Women's French Terry Fleece Crewneck Sweatshirt", 860000, 23, "60% Cotton-40% Polyester, No Closure closure, Machine Wash, Close-but-comfortable fit, Soft and comfortable French terry fleece,Crew neckline", Wrangler);

        womenCloths.addProduct(womenCloth1);
        womenCloths.addProduct(womenCloth2);
        womenCloths.addProduct(womenCloth3);

        Product menCloth1 = new Product(1,"Men's All Purpose Socks", 85000, 68, "79% Cotton-19% Polyester-1% Nylon-1% Spandex, Machine Wash, Soft and breathable cotton, Comfortable full cushion foot Durable, reinforced heel and toe, No-slip", Dickies);
        Product menCloth2 = new Product(2,"Men's Classic All-Sport Waterproof Breathable Rain Suit",2000000 , 8, "100% Polypropylene, Pull-On closure, Machine Wash, WATERPROOF", FROGG_TOGGS);

        menCloths.addProduct(menCloth1);
        menCloths.addProduct(menCloth2);

        Product kidCloth1 = new Product(1,"Unisex-Child Taye 2.0 First Walker Shoe", 1200000, 14, "100% Synthetic, Man Made sole, Shaft measures approximately not_applicable from arch", Stride_Rite360);

        kidCloths.addProduct(kidCloth1);

        Product book1 = new Product(1,"Harry Potter Paperback Box Set (Books 1-7)", 2500000, 100, "by J.K.Rowling, Reading age: 9+ years", Scholastic_Inc);
        Product book2 = new Product(2,"The Secret", 95000, 45, "by Rhonda Byrne, 216 pagesو ", Ketabkala);
        Product book3 = new Product(3,"Sejong Korean Conversation 1", 380000, 25, "14 units with various activities: Let's Practice, Let's Talk, Let's Listen and Speak", Ketabkala);

        book.addProduct(book1);
        book.addProduct(book2);
        book.addProduct(book3);

        Product backpack1 = new Product(1,"Adult Backpack with 15-Inch Laptop Sleeve", 900000,10 ,"Comfort shoulder straps, color:black" , Carhartt_Unisex);
        Product backpack2 = new Product(2,"Under Armour Hustle Sport Backpack", 1200000, 8, "100% Polyester, color:gray, Synthetic lining, Zipper closure", Carhartt_Unisex);

        backpack.addProduct(backpack1);
        backpack.addProduct(backpack2);

        Product Electric1 = new Product(1,"Deluxe Canister Steam Cleaner with 23 Accessories", 5000000, 4, "Chemical-Free Pressurized Cleaning for Most Floors, Counters, Appliances, Windows, Autos, and More, 1-(Pack), Black", McCulloch_Store);
        Product Electric2 = new Product(2,"Smart TV with Apple AirPlay and Chromecast Built-in, 2022 Model", 7500000, 6, "40-inch D-Series Full HD 1080p", VIZIO);

        electricHouseholdAppliances.addProduct(Electric1);
        electricHouseholdAppliances.addProduct(Electric2);

        Product kitchen1 = new Product(1,"Digital Cool-Touch Rice Grain Cooker and Food Steamer", 1100000, 5," Stainless, Silver, 4-Cup (Uncooked) / 8-Cup (Cooked)", Aroma);
        Product kitchen2 = new Product(2,"Single Serve K-Cup Pod Coffee Maker", 3000000, 6, "", Keurig);

        kitchenUtensils.addProduct(kitchen1);
        kitchenUtensils.addProduct(kitchen2);

        Product bedding1 = new Product(1,"Lucid 3 Inch Mattress Topper Queen",200000 , 18, "Gel Infused Memory Foam – Memory Foam Mattress Topper Queen – Ventilated Design – CertiPur Certified", Lucid);
        Product bedding2 = new Product(2,"Cooling Bed Pillows for Sleeping", 550000, 6, "Quality 3D Microfiber Filling with Breathable Cover for Side Back and Stomach Sleepers, Reduces Neck Pain,(Pack of 2), Black", Acanva);

        bedding.addProduct(bedding1);
        bedding.addProduct(bedding2);

        Product makeup1 = new Product(1,"Waterproof Liquid Eye Liner",310000 ,17 , "Intense Black, The fine marker-like tip offers precise application for everyone from novices to pros.", stila);
        Product makeup2 = new Product(2,"Washable Mascara Volumizing",  450000 ,22, "Lengthening, Curling, Multiplying,Blackest Black", Maybelline);

        makeUp.addProduct(makeup1);
        makeUp.addProduct(makeup2);

        Product skincare1 = new Product(1,"Tinted Sunscreen",620000 ,11 , " with SPF 30 | Hydrating Mineral Sunscreen With Zinc Oxide & Titanium Dioxide | Sheer Tint for Healthy Glow | 1.7 Fluid Ounce", CeraVe);
        Product skincare2 = new Product(2,"Gentle Facial Cleanser with Pump Dispenser",570000 ,34 ,"8 fl oz - Formulated Without Common Irritants for Those with Sensitive Skin", Vanicream);

        skinCare.addProduct(skincare1);
        skinCare.addProduct(skincare2);

        Product hairCare1 = new Product(1,"Leave-In Conditioner Spray & Detangler",  390000,27, "Anti-Frizz Deep Conditioner For Split Ends & Breakage - Vitamin E, Caffeine & Ginseng for Curly, Dry & Damaged Hair", Anthony);
        Product haircare2 = new Product(2,"Hair Dryer 1875W Mid-Size",2800000 ,9, "color:White, Lightweight, Power Source:Corded Electric", Conair);

        hairCare.addProduct(hairCare1);
        hairCare.addProduct(haircare2);

        Service.addToProductsList(womenCloth3);
        Service.addToProductsList(womenCloth2);
        Service.addToProductsList(womenCloth1);
        Service.addToProductsList(menCloth1);
        Service.addToProductsList(menCloth2);
        Service.addToProductsList(kidCloth1);
        Service.addToProductsList(makeup1);
        Service.addToProductsList(makeup2);
        Service.addToProductsList(hairCare1);
        Service.addToProductsList(haircare2);
        Service.addToProductsList(skincare1);
        Service.addToProductsList(skincare2);
        Service.addToProductsList(cellPhone1);
        Service.addToProductsList(cellPhone2);
        Service.addToProductsList(cellPhone3);
        Service.addToProductsList(cellPhone4);
        Service.addToProductsList(laptop1);
        Service.addToProductsList(laptop2);
        Service.addToProductsList(laptop3);
        Service.addToProductsList(smartWatch1);
        Service.addToProductsList(smartWatch2);
        Service.addToProductsList(headphone1);
        Service.addToProductsList(headphone2);
        Service.addToProductsList(headphone3);
        Service.addToProductsList(Electric1);
        Service.addToProductsList(Electric2);
        Service.addToProductsList(kitchen1);
        Service.addToProductsList(kitchen2);
        Service.addToProductsList(bedding1);
        Service.addToProductsList(bedding2);
        Service.addToProductsList(book1);
        Service.addToProductsList(book2);
        Service.addToProductsList(book3);
        Service.addToProductsList(backpack1);
        Service.addToProductsList(backpack2);

        USER me = new USER("m", "m", "sdfg", 1234, "dfg", 1000000000);
        Service.addUser(me);

        ADMIN A1 = new ADMIN("a1","111","aaa");
        Service.addAdmin(A1);

        SELLER q = new SELLER("q", "q", 0.0);
        Service.addSeller(q);


        START();

    }
}