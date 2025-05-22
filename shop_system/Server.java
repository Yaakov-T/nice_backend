package shop_system;

import java.util.*;
import java.util.stream.Stream;

public class Server {
    private Map<String, Product> productMap = new HashMap<>();
    private Queue<Product> productQueue = new LinkedList<>();

    public void addProduct(Product product) {
        productMap.put(product.name, product);
        productQueue.add(product);
    }

    public Queue<Product> getProductByInsert() {
        return productQueue;
    }

    public Queue<Product> getProductByCategory(Category category) {
        Queue<Product> result = new LinkedList<>();
        for (Product product : productMap.values()) {
            if (product.category == category) {
                result.add(product);
            }
        }
        return result;
    }
    

    public boolean riseProductQuantity(String name) {
        Product product = productMap.get(name);
        if (product != null) {
            product.quantity++;
            return true;
        }
        return false;
    }
}
