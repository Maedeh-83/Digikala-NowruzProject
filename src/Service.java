import java.util.*;

public class Service {
    private static List<USER> usersList = new ArrayList<>();
    private static List<Product> productsList;
    private static List<Product> ordersList;
    private static List<Double> totalProfit;
    Scanner input = new Scanner(System.in);

    public Service() {
        this.usersList = new ArrayList<>();
        this.productsList = new ArrayList<>();
        this.ordersList = new ArrayList<>();
        this.totalProfit = new ArrayList<>();
    }

    public static void viewUsers() {
        for (USER user : usersList) {
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            System.out.println(user.getEmail());
            System.out.println(user.getAddress());
            System.out.println(user.getPhoneNumber());
        }
    }


    public List<USER> getUsersList() {
        return usersList;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public List<Product> getOrdersList() {
        return ordersList;
    }

    public List<Double> getTotalProfit() {
        return totalProfit;
    }

    public static void creatAccount() {
        Scanner input = new Scanner(System.in);
        String username;
        String password;
        String email;
        int phoneNumber;
        String address;

        System.out.println("Creating a new account:");
        System.out.println(" ");
        System.out.println("Enter an username:");
        username = input.nextLine();
        System.out.println("Enter a password:");
        password = input.nextLine();
        System.out.println("Enter your email:");
        email = input.nextLine();
        System.out.println("Enter your address:");
        address = input.nextLine();
        System.out.println("Enter your phone number:");
        phoneNumber = input.nextInt();

        USER newAccount = new USER(username, password, email, phoneNumber, address, 0.0);
        usersList.add(newAccount);
        System.out.println("your account created succefully!");
    }

    public void Login() {

        String username;
        String password;

        System.out.println("Login:");
        System.out.println(" ");
        System.out.println("Enter your username:");
        username = input.nextLine();
        System.out.println("Enter your password:");
        password = input.nextLine();
        for (USER user : usersList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("you logged in (:");
            } else {
                System.out.println("user not found!");
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
                    }
                }
                break;

            case 2 :
                System.out.println("Enter your new password:");
                String newPassword = input.next();
                for (USER user : usersList) {
                    if (user.getPassword().equals(currentPassword)) {
                        user.setUsername(newPassword);
                    }
                }
                break;


            case 3 :
                System.out.println("Enter your new email:");
                String newEmail = input.next();
                for(USER user : usersList){
                    if(user.getUsername().equals(currentUsername) && user.getPassword().equals(currentPassword)){
                        user.setEmail(newEmail);
                    }
                }
                break;

            case 4 :
                System.out.println("Enter your new phone number:");
                int newPhoneNumber = input.nextInt();
                for(USER user : usersList){
                    if(user.getUsername().equals(currentUsername) && user.getPassword().equals(currentPassword)){
                        user.setPhoneNumber(newPhoneNumber);
                    }
                }
                break;

            case 5 :
                System.out.println(" ");
                String x = input.nextLine();
                System.out.println("Enter your new address:");
                String newAddress = input.nextLine();
                for(USER user : usersList){
                    if(user.getUsername().equals(currentUsername) && user.getPassword().equals(currentPassword)){
                        user.setAddress(newAddress);
                    }
                }
                break;

        }


        }



    }

