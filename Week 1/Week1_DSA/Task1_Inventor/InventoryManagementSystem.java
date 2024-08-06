
import java.util.Scanner;

public class InventoryManagementSystem {
    private static Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    listProducts();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Inventory Management System");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. List Products");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(id, name, quantity, price);
        inventory.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter new Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter new Price: ");
        double price = scanner.nextDouble();

        inventory.updateProduct(id, name, quantity, price);
        System.out.println("Product updated successfully.");
    }

    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = scanner.nextInt();

        inventory.deleteProduct(id);
        System.out.println("Product deleted successfully.");
    }

    private static void listProducts() {
        inventory.listProducts();
    }
}
