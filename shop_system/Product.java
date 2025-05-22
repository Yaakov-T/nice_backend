package shop_system;

public class Product {
    public String name;
    public Category category;
    public int quantity;
    public double price;

    public Product(String name, Category category, int quantity, double price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + name +
                "  Category: " + category +
                "  Quantity: " + quantity +
                "  Price: " + price;
    }
}
