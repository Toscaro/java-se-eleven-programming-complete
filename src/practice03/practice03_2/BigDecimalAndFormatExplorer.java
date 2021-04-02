package practice03.practice03_2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class BigDecimalAndFormatExplorer {

    public static void main(String[] args) {
        /*
            1)
            Run the following commands in Jshell:
            Note:
            - The "System.out.println" is performed by JShell after some command execution.
        */

        // A)
        double price = 1.85;
        double rate = 0.065;
        System.out.println("price: " + price);
        System.out.println("rate: " + rate);

        price -= price * rate;
        System.out.println("price: " + price);

        price = Math.round(price * 100) / 100.0;
        System.out.println("price: " + price);

        // B) Import BigDecimal and RoundingMode classes.

        // C)
        BigDecimal priceBigDecimal = BigDecimal.valueOf(1.85);
        BigDecimal rateBigDecimal = BigDecimal.valueOf(0.065);
        System.out.println("priceBigDecimal: " + priceBigDecimal);
        System.out.println("rateBigDecimal: " + rateBigDecimal);

        priceBigDecimal =
                priceBigDecimal.subtract(
                        priceBigDecimal.multiply(rateBigDecimal)
                                .setScale(2, RoundingMode.HALF_UP));

        System.out.println("priceBigDecimal: " + priceBigDecimal);


        // 2)

        // A) Import Locale and NumberFormat classes.

        // B)
        Locale locale = Locale.FRANCE;

        // C)
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        NumberFormat percentFormat = NumberFormat.getPercentInstance(locale);

        // D)
        percentFormat.setMaximumFractionDigits(2);

        // E)
        String format = currencyFormat.format(priceBigDecimal);
        String format1 = percentFormat.format(rateBigDecimal);
        System.out.println("currencyFormat: " + format);
        System.out.println("percentFormat: " + format1);

        // F)
        locale = Locale.UK;
        System.out.println(locale);

        // G)
        currencyFormat = NumberFormat.getCurrencyInstance(locale);
        percentFormat = NumberFormat.getPercentInstance(locale);
        percentFormat.setMaximumFractionDigits(2);


        // H)
        String priceTxt = currencyFormat.format(priceBigDecimal);
        String rateTxt = percentFormat.format(rateBigDecimal);
        System.out.println("currencyFormat: " + priceTxt);
        System.out.println("percentFormat: " + rateTxt);
    }
}
