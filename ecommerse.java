public class Product {
    private String id;
    private String name;
    private int quantity;

    public Product(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(String productId, int newQuantity) {
        Product product = getProductById(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void removeProduct(String productId) {
        Product product = getProductById(productId);
        if (product != null) {
            products.remove(product);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void checkStock(String productId) {
        Product product = getProductById(productId);
        if (product != null) {
            System.out.println("Available stock for " + product.getName() + ": " + product.getQuantity());
        } else {
            System.out.println("Product not found.");
        }
    }

    private Product getProductById(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Add product");
            System.out.println("2. Update product quantity");
            System.out.println("3. Remove product");
            System.out.println("4. Check stock");
            System.out.println("5. Exit");

            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Enter product ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter product name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter product quantity:");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    Product product = new Product(id, name, quantity);
                    inventory.addProduct(product);
                    System.out.println("Product added successfully.");
                    break;
                case "2":
                    System.out.println("Enter product ID:");
                    String productId = scanner.nextLine();
                    System.out.println("Enter new quantity:");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    inventory.updateProduct(productId, newQuantity);
                    break;
                case "3":
                    System.out.println("Enter product ID:");
                    String removeProductId = scanner.nextLine();
                    inventory.removeProduct(removeProductId);
                    break;
                case "4":
                    System.out.println("Enter product ID:");
                    String checkProductId = scanner.nextLine();
                    inventory.checkStock(checkProductId);
                    break;
                case "5":
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
