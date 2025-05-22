package shop_system;

public class Main {
    public static void main(String[] args) {
        Actions action = new Actions();

        Product p1 = new Product("Laptop", Category.ELECTRONICS, 10, 3000);
        Product p2 = new Product("T-Shirt", Category.CLOTHES, 50, 80);
        Product p3 = new Product("Apple", Category.FOOD, 100, 2.5);

        action.addProduct(p1);
        action.addProduct(p2);
        action.addProduct(p3);

        action.riseProductQuantity("Laptop");
        action.riseProductQuantity("T-Shirt");
        action.printProductByInsert();
        action.printProductByCategory(Category.CLOTHES);
        action.printProductByCategory(Category.FOOD);
        action.printProductByCategory(Category.ELECTRONICS);
    }
}
