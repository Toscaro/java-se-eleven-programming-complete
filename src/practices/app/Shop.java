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

        productManager.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        productManager.printProductReport(101);

        productManager.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of tea");
        productManager.reviewProduct(101, Rating.TWO_STAR, "Rather weak tea");
        productManager.reviewProduct(101, Rating.FOUR_STAR, "Fine tea");
        productManager.reviewProduct(101, Rating.FOUR_STAR, "Good tea");
        productManager.reviewProduct(101, Rating.FIVE_STAR, "Perfect tea");
        productManager.reviewProduct(101, Rating.THREE_STAR, "Just add some lemon");
        productManager.printProductReport(101);

        productManager.createProduct(102, "Coffee", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
        productManager.reviewProduct(102, Rating.THREE_STAR, "Coffee was ok");
        productManager.reviewProduct(102, Rating.ONE_STAR, "Where is the milk?!");
        productManager.reviewProduct(102, Rating.FIVE_STAR, "It's perfect with ten spoons of sugar");
        productManager.printProductReport(102);
    }
}
