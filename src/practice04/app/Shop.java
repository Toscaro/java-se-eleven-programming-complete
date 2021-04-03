package practice04.app;

import practice04.data.Product;

import java.math.BigDecimal;

/**
 * @author Toscaro
 */
public class Shop {

    public static void main(String[] args) {
        //No constructor.
        Product p1 = new Product();
//        p1.setId(10);
//        p1.setName("Tea");
        p1.setPrice(BigDecimal.valueOf(1.99));

        System.out.println(p1);
    }
}
