import java.util.*;

public class ADMIN {
    private String username;
    private String password;
    private String email;

    public ADMIN(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public static void showProfile(String password) {
        for (ADMIN admin : Service.getAdminsList()) {
            if (admin.getPassword().equals(password)) {
                System.out.println("Username: " + admin.getUsername());
                System.out.println("Password: " + password);
                System.out.println("Email: " + admin.getEmail());
            }
        }
    }
}

