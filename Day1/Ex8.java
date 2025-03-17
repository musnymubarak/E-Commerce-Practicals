import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString() {
        return name + " - $" + price + " - Qty: " + quantity;
    }
}

class Store {
    ArrayList<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        double price = getValidDouble("Enter price: ");
        int quantity = getValidInt("Enter quantity: ");

        products.add(new Product(name, price, quantity));
        System.out.println("Product added!");
    }

    void editProduct() {
        System.out.print("Enter product name to edit: ");
        String name = scanner.nextLine();
        for (Product p : products) {
            if (p.name.equalsIgnoreCase(name)) {
                p.price = getValidDouble("Enter new price: ");
                p.quantity = getValidInt("Enter new quantity: ");
                System.out.println("Product updated!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    void deleteProduct() {
        System.out.print("Enter product name to delete: ");
        String name = scanner.nextLine();
        products.removeIf(p -> p.name.equalsIgnoreCase(name));
        System.out.println("Product deleted if it existed!");
    }

    void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available!");
        } else {
            System.out.println("Available Products:");
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    private double getValidDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    private int getValidInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }
    }
}

public class Ex8 {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n1. Add Product\n2. Edit Product\n3. Delete Product\n4. Display Products\n5. Exit");
            System.out.print("Enter choice: ");

            while (!scanner.hasNextInt()) { // Ensure valid integer input
                System.out.println("Invalid input! Please enter a number from 1 to 5.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1: store.addProduct(); break;
                case 2: store.editProduct(); break;
                case 3: store.deleteProduct(); break;
                case 4: store.displayProducts(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice! Please select from 1 to 5.");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}
