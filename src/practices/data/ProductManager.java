/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package practices.data;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class ProductManager {

    private Map<Product, List<Review>> products = new HashMap<>();

    private Locale locale;
    private ResourceBundle resources;
    private DateTimeFormatter dateFormat;
    private NumberFormat moneyFormat;

    public ProductManager(Locale locale) {
        this.locale = locale;
        this.resources = ResourceBundle.getBundle("practices.data.resources", locale);
        this.dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
        this.moneyFormat = NumberFormat.getCurrencyInstance(locale);
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        final Product product = new Food(id, name, price, rating, bestBefore);
        products.putIfAbsent(product, new ArrayList<>());
        return product;
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating) {
        Product product = new Drink(id, name, price, rating);
        products.putIfAbsent(product, new ArrayList<>());
        return product;
    }

    public Product reviewProduct(int id, Rating rating, String comments) {
        return reviewProduct(findProduct(id), rating, comments);
    }

    public Product reviewProduct(Product product, Rating rating, String comments) {
        final List<Review> reviews = products.get(product);
        // Product object is immutable when applying rating, so we have to remove it, apply rating and adding the new object again.
        products.remove(product, reviews);
        reviews.add(new Review(rating, comments));

        int sum = 0;
        for (Review review : reviews) {
            sum += review.getRating().ordinal();
        }

        product = product.applyRating(Rateable.convert(Math.round((float) sum / reviews.size())));
        products.put(product, reviews);
        return product;
    }

    public Product findProduct(int id) {
        Product result = null;
        for (Product product : products.keySet()) {
            if (product.getId() == id) {
                result = product;
                break;
            }
        }
        return result;
    }

    public void printProductReport(int id) {
            printProductReport(findProduct(id));
    }

    public void printProductReport(Product product) {
        final StringBuilder txt = new StringBuilder();
        txt.append(MessageFormat.format(resources.getString("product"),
                product.getName(),
                moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore())));
        txt.append('\n');

        final List<Review> reviews = products.get(product);
        Collections.sort(reviews);
        for (final Review review : reviews) {
            if (review == null) {
                break;
            }
            txt.append(MessageFormat.format(resources.getString("review"),
                    review.getRating().getStars(),
                    review.getComments()));
            txt.append('\n');
        }
        if (reviews.isEmpty()) {
            txt.append(resources.getString("no.reviews"));
            txt.append('\n');
        }
        System.out.println(txt);
    }
}
