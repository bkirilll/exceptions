package seminars.first.hw;

import java.util.*;

public class Shop {
    private List<Product> products;

    public Shop() {

    }

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        Collections.sort(this.products);
        return this.products;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        return (Product)this.getSortedListProducts().get(this.products.size()-1);
    }
}