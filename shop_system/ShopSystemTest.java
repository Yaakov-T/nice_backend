package shop_system;

import java.util.Queue;

public class ShopSystemTest {

    public static void main(String[] args) {
        testPrintByInsert();
        testPrintByCategory();
        testRiseProductQuantity();
        System.out.println("All tests passed.");
    }

    public static void testAddProduct() {
        System.out.println("=== Test: Add Product ===");
        Actions action = new Actions();
        Product p1 = new Product("TV", Category.ELECTRONICS, 5, 1500);
        Product p2 = new Product("Banana", Category.FOOD, 30, 1.2);
        action.addProduct(p1);
        action.addProduct(p2);

        Queue<Product> products = action.server.getProductByInsert();
        if (products.size() != 2) {
            throw new AssertionError("Expected 2 products, but got " + products.size());
        }
        Product firstProduct = products.poll();
        Product secondProduct = products.poll();
        if (firstProduct == null || secondProduct == null || 
            !firstProduct.name.equals("TV") || !secondProduct.name.equals("Banana")) {
            throw new AssertionError("Product order or names incorrect");
        }
    }

    public static void testPrintByInsert() {
        System.out.println("=== Test: Print by Insert ===");
        Actions action = new Actions();
        Product p1 = new Product("TV", Category.ELECTRONICS, 5, 1500);
        Product p2 = new Product("Banana", Category.FOOD, 30, 1.2);
        action.addProduct(p1);
        action.addProduct(p2);

        Queue<Product> inserted = action.server.getProductByInsert();

        if (inserted.size() != 2) {
            throw new AssertionError("Expected 2 products, but got " + inserted.size());
        }
        Product firstProduct = inserted.poll();
        Product secondProduct = inserted.poll();
        if (firstProduct == null || secondProduct == null || 
            !firstProduct.name.equals("TV") || !secondProduct.name.equals("Banana")) {
            throw new AssertionError("Product order or names incorrect");
        }
    }

    public static void testPrintByCategory() {
        System.out.println("=== Test: Print by Category ===");
        Actions action = new Actions();
        action.addProduct(new Product("Shirt", Category.CLOTHES, 10, 50));
        action.addProduct(new Product("Milk", Category.FOOD, 20, 5));

        Queue<Product> clothes = action.server.getProductByCategory(Category.CLOTHES);
        if (clothes.size() != 1 || !clothes.poll().name.equals("Shirt")) {
            throw new AssertionError("Expected 1 product named 'Shirt' in CLOTHES category");
        }
    }

    public static void testRiseProductQuantity() {
        System.out.println("=== Test: Rise Product Quantity ===");
        Actions action = new Actions();
        action.addProduct(new Product("Camera", Category.ELECTRONICS, 1, 2000));

        boolean success = action.server.riseProductQuantity("Camera");
        Queue<Product> products = action.server.getProductByCategory(Category.ELECTRONICS);

        if (!success) {
            throw new AssertionError("riseProductQuantity returned false");
        }
        Product product = products.poll();
        if (products.size() != 0 || product == null || product.quantity != 2) {
            throw new AssertionError("Expected quantity to be 2 after rising, but got " + product.quantity);
        }
    }
}
