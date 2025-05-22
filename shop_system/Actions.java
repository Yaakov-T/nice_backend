package shop_system;

import java.util.Queue;

public class Actions {
    Server server = new Server();

    public void addProduct(Product product) {
        server.addProduct(product);
    }

    public void printProducts(Queue <Product> products) {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void printProductByInsert() {
        System.out.println("Products by insert:");
        printProducts(server.getProductByInsert());
    }

    public void printProductByCategory(Category category) {
        System.out.println("Products by category: " + category);
        printProducts(server.getProductByCategory(category));
    }

    public void riseProductQuantity(String name) {
        server.riseProductQuantity(name);
    }
}
