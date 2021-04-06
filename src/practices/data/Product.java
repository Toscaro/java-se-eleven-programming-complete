/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package practices.data;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * {@code Product} class represents properties and behaviours of
 * product objects in the Product Management System.
 * <br>
 * Each product has an id, name, and price.
 * <br>
 * Each product can have a discount, calculated based on a
 * {@link DISCOUNT_RATE discount rate}
 *
 * @author Toscaro
 * @version 4.0
 */
public class Product {
    /**
     * A constant that defines a
     * {@link BigDecimal BigDecimal} value of the discount rate
     * <br>
     * Discount rate is 10%
     */
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    private int id;
    private String name;
    private BigDecimal price;
    private Rating rating;

    public Product() {
        this(0, "no name", BigDecimal.ZERO);
    }

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public Product(int id, String name, BigDecimal price) {
        this(id, name, price, Rating.NOT_RATED);
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
//        price = BigDecimal.ONE; (Impossible to reassign parameter being final.)
        this.price = price;
    }

    /**
     * Calculates discount based on a product price and
     * {@link DISCOUNT_RATE discount rate}
     *
     * @return a {@link BigDecimal BigDecimal} value of the discount
     */
    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + getPrice() + " " + getDiscount() + " " + getRating().getStars();
    }
}
