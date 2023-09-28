package seminars.first.hw;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShopTest {

    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */

    public static void main(String[] args) {
        Shop shopTest = new Shop();
        shopTest.setProducts(getTestProducts());
        assertThat(shopTest.getProducts()).hasSize(3);
        assertThat(shopTest.getSortedListProducts().get(0).getCost()).isEqualTo(3);
        assertThat(shopTest.getSortedListProducts().get(1).getCost()).isEqualTo(5);
        assertThat(shopTest.getSortedListProducts().get(2).getCost()).isEqualTo(7);
        assertThat(shopTest.getMostExpensiveProduct().getCost()).isEqualTo(7);
    }

    static List<Product> getTestProducts() {
        Product product1 = new Product();
        product1.setTitle("Apple");
        product1.setCost(5);
        Product product2 = new Product();
        product2.setTitle("Banana");
        product2.setCost(7);
        Product product3 = new Product();
        product3.setTitle("Water");
        product3.setCost(3);
        List<Product> productList = new ArrayList();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        return productList;
    }

}




