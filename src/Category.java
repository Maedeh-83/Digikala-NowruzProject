import java.util.*;

public class Category {
    private String name;
    private List<Product> products;
    private ArrayList<Category> subCategories;

    public Category(String name) {
        this.name = name;
        products = new ArrayList<>();
        subCategories = new ArrayList<>();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public List<Product> getProducts() {
        return products;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public ArrayList<Category> getSubCategories() {
        return subCategories;
    }
    public void addSubCategories(Category sub){
        this.subCategories.add(sub);
    }
}
