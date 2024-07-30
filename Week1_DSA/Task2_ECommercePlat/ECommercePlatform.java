import java.util.Arrays;
import java.util.Comparator;

public class ECommercePlatform {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Tablet", "Electronics"),
            new Product(4, "Monitor", "Electronics"),
            new Product(5, "Keyboard", "Electronics")
        };

        // Linear search example
        Product linearResult = LinearSearch.linearSearch(products, 3);
        System.out.println("Linear Search Result: " + (linearResult != null ? linearResult : "Product not found"));

        // Sort the array for binary search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        // Binary search example
        Product binaryResult = BinarySearch.binarySearch(products, 3);
        System.out.println("Binary Search Result: " + (binaryResult != null ? binaryResult : "Product not found"));
    }
}
