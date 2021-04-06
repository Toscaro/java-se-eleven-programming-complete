package introduction.practice03.practice03_4;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleAndFormatMessagesExplorer {
    public static void main(String[] args) {
        /*
            1)
            Run the following commands in Jshell:
            Note:
            - The "System.out.println" is performed by JShell after some command execution.
        */

        // Important, move the resource folder with files called practice03_messages to base src/ folder.

        // A) Import the following classes: ResourceBundle and MessageFormat.

        // B)
        Locale locale = Locale.UK;
        ResourceBundle msg = ResourceBundle.getBundle("practice03_messages", locale);
        System.out.println(msg);

        // C)
        String offerPattern = msg.getString("offer");
        System.out.println(offerPattern);


        // D)
        String teaText = "Tea";
        String priceTxt = "£1.73";
        String rateTxt = "6.5%";
        String timeTxt = "Sat, 3 of April 2021 at 22:15 NPT";

        String messageFormat = MessageFormat.format(offerPattern, teaText, priceTxt, rateTxt, timeTxt);
        System.out.println(messageFormat);


        // 2)

        // A) Duplicate the message file

        // B) Apply some translation

        // C/D) Save the file

        // E)
        locale = new Locale("pt", "BR");
        System.out.println(locale);

        // F)
        msg = ResourceBundle.getBundle("practice03_messages", locale);
        System.out.println(msg);

        // G)
        String datePattern = msg.getString("dateFormat");
        offerPattern = msg.getString("offer");
        System.out.println(offerPattern);
        System.out.println(datePattern);

        // H)
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);
        System.out.println(currencyFormat);
        System.out.println(percentFormat);

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(datePattern, locale);
        System.out.println(dateFormat);

        // I)
        teaText = "Cha";
        priceTxt = currencyFormat.format(1.73);
        rateTxt = percentFormat.format(0.065);
        ZoneId kathmandu = ZoneId.of("Asia/Kathmandu");

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalTime tomorrowTime = LocalTime.of(17, 30);
        LocalDateTime tomorrowDateTime = LocalDateTime.of(tomorrow, tomorrowTime);

        timeTxt = dateFormat.format(ZonedDateTime.of(tomorrowDateTime, kathmandu));
        System.out.println(teaText);
        System.out.println(priceTxt);
        System.out.println(rateTxt);
        System.out.println(timeTxt);

        // J)
        messageFormat = MessageFormat.format(offerPattern, teaText, priceTxt, rateTxt, timeTxt);
        System.out.println(messageFormat);

        // K) Close JShell with /exit
    }
}
