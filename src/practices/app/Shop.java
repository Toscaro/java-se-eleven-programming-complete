/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package practices.app;

import practices.data.Product;
import practices.data.ProductManager;
import practices.data.Rating;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * {@code Shop} class represents an application that manages Products.
 *
 * @author Toscaro
 * @version 4.0
 */
public class Shop {

    public static void main(String[] args) {
        final ProductManager productManager = new ProductManager(Locale.UK);

        Product p1 = productManager.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        productManager.printProductReport(p1);
        p1 = productManager.reviewProduct(p1, Rating.FOUR_STAR, "Nice hot cup of tea");
        p1 = productManager.reviewProduct(p1, Rating.TWO_STAR, "Rather weak tea");
        p1 = productManager.reviewProduct(p1, Rating.FOUR_STAR, "Fine tea");
        p1 = productManager.reviewProduct(p1, Rating.FOUR_STAR, "Good tea");
        p1 = productManager.reviewProduct(p1, Rating.FIVE_STAR, "Perfect tea");
        p1 = productManager.reviewProduct(p1, Rating.THREE_STAR, "Just add some lemon");
        productManager.printProductReport(p1);

        Product p2 = productManager.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        p2 = productManager.reviewProduct(p2, Rating.THREE_STAR, "Coffee was ok");
        p2 = productManager.reviewProduct(p2, Rating.ONE_STAR, "Where is the milk?!");
        p2 = productManager.reviewProduct(p2, Rating.FIVE_STAR, "It's perfect with ten spoons of sugar");
        productManager.printProductReport(p2);
    }
}
