/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package practices.app;

import practices.data.Product;
import practices.data.Rating;

import java.math.BigDecimal;

/**
 * {@code Shop} class represents an application that manages Products.
 *
 * @author Toscaro
 * @version 4.0
 */
public class Shop {

    public static void main(String[] args) {
        //No constructor.
        Product p1 = new Product(10, "Tea", BigDecimal.valueOf(1.99));
        Product p2 = new Product(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        Product p3 = new Product(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR);
        Product p4 = new Product();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
    }
}
