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
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;

/**
 * {@code Shop} class represents an application that manages Products.
 *
 * @author Toscaro
 * @version 4.0
 */
public class Shop {

    public static void main(String[] args) {
        final ProductManager productManager = new ProductManager(Locale.CANADA_FRENCH);

        productManager.createProduct(101, "Tea", BigDecimal.valueOf(1.99), Rating.NOT_RATED);
//        productManager.printProductReport(101);

        productManager.reviewProduct(101, Rating.FOUR_STAR, "Nice hot cup of tea");
        productManager.reviewProduct(101, Rating.TWO_STAR, "Rather weak tea");
        productManager.reviewProduct(101, Rating.FOUR_STAR, "Fine tea");
        productManager.reviewProduct(101, Rating.FOUR_STAR, "Good tea");
        productManager.reviewProduct(101, Rating.FIVE_STAR, "Perfect tea");
        productManager.reviewProduct(101, Rating.THREE_STAR, "Just add some lemon");
//        productManager.printProductReport(101);

//        productManager.changeLocale(Locale.US.toLanguageTag());
        productManager.createProduct(102, "Coffee", BigDecimal.valueOf(2.99), Rating.NOT_RATED);
        productManager.reviewProduct(102, Rating.THREE_STAR, "Coffee was ok");
        productManager.reviewProduct(102, Rating.ONE_STAR, "Where is the milk?!");
        productManager.reviewProduct(102, Rating.FIVE_STAR, "It's perfect with ten spoons of sugar");
//        productManager.printProductReport(102);

        productManager.createProduct(103, "Cake", BigDecimal.valueOf(3.99), Rating.NOT_RATED, LocalDate.now().plusDays(2));
        productManager.reviewProduct(103, Rating.ONE_STAR, "Cake was not so good");
        productManager.reviewProduct(103, Rating.ONE_STAR, "Cake was not so good");
        productManager.reviewProduct(103, Rating.ONE_STAR, "Cake was not so good");
        productManager.reviewProduct(103, Rating.ONE_STAR, "Cake was not so good");
        productManager.reviewProduct(103, Rating.ONE_STAR, "Cake was not so good");
        productManager.reviewProduct(103, Rating.TWO_STAR, "Too sweet");
        productManager.reviewProduct(103, Rating.FIVE_STAR, "It's perfect!");


        productManager.getDiscount().forEach((rating, discount) -> System.out.println(rating + "\t" + discount));
        Comparator<Product> ratingSorter = (p1, p2) -> p2.getRating().ordinal() - p1.getRating().ordinal();
//        Comparator<Product> priceSorter = (p1, p2) -> p2.getPrice().compareTo(p1.getPrice());
        productManager.printProducts(product -> product.getPrice().floatValue() < 2, ratingSorter);
//        productManager.printProducts(priceSorter);

//        productManager.printProducts(ratingSorter.thenComparing(priceSorter));
//        productManager.printProducts(ratingSorter.thenComparing(priceSorter).reversed());
    }
}
