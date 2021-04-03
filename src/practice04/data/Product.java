package practice04.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @author Toscaro
 */
public class Product {
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    private int id;
    private String name;
    private BigDecimal price;

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

    public BigDecimal getDiscount() {
        BigDecimal discount = price.multiply(DISCOUNT_RATE).setScale(2, RoundingMode.HALF_UP);
        return discount;
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + getPrice() + " " + getDiscount();
    }
}
