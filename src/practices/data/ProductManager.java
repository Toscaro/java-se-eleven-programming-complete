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
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductManager {

    private Product product;
    private Review[] reviews = new Review[5];
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
        return product = new Food(id, name, price, rating, bestBefore);
    }

    public Product createProduct(int id, String name, BigDecimal price, Rating rating) {
        return product = new Drink(id, name, price, rating);
    }

    public Product reviewProduct(Product product, Rating rating, String comments) {
        if (reviews[reviews.length - 1] != null) {
            reviews = Arrays.copyOf(reviews, reviews.length + 5);
        }

        int sum = 0, i = 0;
        boolean reviewed = false;

        while (i < reviews.length && !reviewed) {
            if (reviews[i] == null) {
                reviews[i] = new Review(rating, comments);
                //I did this way because the course says to. It also can be done with a simple "break;" to go out from while loop
                reviewed = true;
            }
            sum += reviews[i].getRating().ordinal();
            i++;
        }
        this.product = product.applyRating(Rateable.convert(Math.round((float) sum / i)));
        return this.product;
    }

    public void printProductReport() {
        final StringBuilder txt = new StringBuilder();
        txt.append(MessageFormat.format(resources.getString("product"),
                product.getName(),
                moneyFormat.format(product.getPrice()),
                product.getRating().getStars(),
                dateFormat.format(product.getBestBefore())));
        txt.append('\n');
        for (Review review : reviews) {
            if (review == null) {
                break;
            }
            txt.append(MessageFormat.format(resources.getString("review"),
                    review.getRating().getStars(),
                    review.getComments()));
            txt.append('\n');
        }
        if (reviews[0] == null){
            txt.append(resources.getString("no.reviews"));
            txt.append('\n');
        }
        System.out.println(txt);
    }
}
