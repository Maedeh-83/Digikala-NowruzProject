import java.util.*;
import java.io.FileOutputStream;
import java.io.IOError;
import java.util.Properties;

public class Main {

    public static void START(){
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
                System.out.println("Have you allready Get authorization from an admin?");
                System.out.println("1-Yes     2-No");
                int ans1 = input.nextInt();
                if(ans1 == 1){ Service.sellerLogin(); }
                if(ans1 == 2){ SELLER.getPermission(); }
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
        System.out.println("5.Favorites");
        System.out.println("6.Cart");
        System.out.println("7.Orders");
        System.out.println("8.Contact us");
        System.out.println("9.Logout");

        int option = input.nextInt();

        switch (option) {

            case 1 :
                // USER.showProfile();
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
                        break;

                    case 2 :
                        System.out.println("1-Makeup");
                        System.out.println("2-Skin care");
                        System.out.println("3-Hair care");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub2 = input.nextInt();

                        break;

                    case 3 :
                        System.out.println("1-Cell Phones");
                        System.out.println("2-Laptops");
                        System.out.println("3-Smart watches");
                        System.out.println("4-Headphones");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub3 = input.nextInt();

                        break;

                    case 4 :
                        System.out.println("1-Electric household appliances");
                        System.out.println("2-Kitchen Utensils");
                        System.out.println("3-bedding");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub4 = input.nextInt();
                        break;

                    case 5 :
                        System.out.println("1-Book");
                        System.out.println("2-Notebook & Paper");
                        System.out.println("3-Bag and solidity");
                        System.out.println("------------------------------");
                        System.out.println("<Enter your desired sub category>");
                        int sub5 = input.nextInt();
                        break;
                }




                break;

            case 4 :

                break;

            case 5 :

                break;

            case 6 :

                break;

            case 7 :

                break;

            case 8 :

                break;

            case 9 :

                break;
        }





    }

    public static void adminPanel() {

    }

    public static void sellerPanel() {

    }


    /* دسته بندی پوشاک
        Category modAndCloths = new Category("Mod And Cloths");
        Category womenCloths = new Category("Women Cloths");
        Category menCloths = new Category("Men Cloths");
        Category kidCloths = new Category("Kid Cloths");
        modAndCloths.addSubCategories(womenCloths);
        modAndCloths.addSubCategories(menCloths);
        modAndCloths.addSubCategories(kidCloths);

        System.out.println(modAndCloths.getName());
        for(Category sub : modAndCloths.getSubCategories()){
            System.out.println(sub.getName());
                  }  */


    // test this methods!
        /*Service.creatUserAccount();

        Service.editPersonalInformation();

        Service.viewUsers();
        */

    //search
        /*Scanner input = new Scanner(System.in);
        System.out.println("What do you want to search?");
        String name = input.next();
        ArrayList<Product> result =  Service.search(name);
        for(Product product : result){
            System.out.println("name: "product.getName()+ " - price: "+ product.getPrice()+ " - details: "+ product.getAdditionalData()+ " - available:" + product.getQuantity());
        }  */


    public static void main(String[] args) {

        Category modAndCloths = new Category("1***Mod And Cloths");
        Category womenCloths = new Category("1-Women Cloths");
        Category menCloths = new Category("2-Men Cloths");
        Category kidCloths = new Category("3-Kid Cloths");
        Category beautyAndPersonalCare = new Category("2***Beauty And Personal Care");
        Category makeUp = new Category("1-Makeup");
        Category skinCare = new Category("2-Skin care");
        Category hairCare = new Category("3-Hair care");
        Category electronics = new Category("3***Electronics");
        Category cellPhones = new Category("1-Cell Phones");
        Category laptops = new Category("2-Laptops");
        Category smartWatches = new Category("3-Smart watches");
        Category headphones = new Category("4-Headphones");
        Category homeAndKitchen = new Category("4***Home And Kitchen");
        Category electricHouseholdAppliances = new Category("1-Electric household appliances");
        Category kitchenUtensils = new Category("2-Kitchen Utensils");
        Category bedding = new Category("3-bedding");
        Category booksAndStationery = new Category("5***Books & Stationery");
        Category book = new Category("1-Book");
        Category notrbookAndpaper = new Category("2-Notebook & Paper");
        Category bagAndSolidity = new Category("3-Bag and solidity");

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
        booksAndStationery.addSubCategories(bagAndSolidity);

        Service.addCategory(modAndCloths);
        Service.addCategory(beautyAndPersonalCare);
        Service.addCategory(electronics);
        Service.addCategory(homeAndKitchen);
        Service.addCategory(booksAndStationery);


        START();

    }
}