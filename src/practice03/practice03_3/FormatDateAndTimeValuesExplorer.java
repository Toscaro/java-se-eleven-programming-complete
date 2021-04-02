package practice03.practice03_3;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDateAndTimeValuesExplorer {

    public static void main(String[] args) {
        /*
            1)
            Run the following commands in Jshell:
            Note:
            - The "System.out.println" is performed by JShell after some command execution.
        */

        // A) Import the following classes: LocalDate, LocalTime, LocalDateTime, and Duration.

        // B)
        LocalDate today = LocalDate.now();
        System.out.println(today);

        // C)
        LocalDate plusYears = today.plusYears(1);
        System.out.println(plusYears);
        System.out.println(plusYears.getDayOfWeek());

        // D)
        LocalTime teaTime = LocalTime.of(17, 30);
        System.out.println(teaTime);

        // E)
        Duration timeGap = Duration.between(LocalTime.now(), teaTime);
        System.out.println(timeGap);

        // F)
        System.out.println(timeGap.toMinutes());
        System.out.println(timeGap.toHours());
        System.out.println(timeGap.toMinutesPart());

        // G)
        LocalDateTime tomorrowTeaTime = LocalDateTime.of(today, teaTime);
        tomorrowTeaTime = tomorrowTeaTime.plusDays(1); //tomorrowDate.
        //It can be inline: LocalDateTime tomorrowTeaTime = LocalDateTime.of(today.plusDays(1), teaTime);
        System.out.println(tomorrowTeaTime);


        // 2)

        // A) Import the following classes: ZoneId, ZonedDateTime;

        // B)

        ZoneId london = ZoneId.of("Europe/London");
        ZoneId kathmandu = ZoneId.of("Asia/Kathmandu");
        System.out.println(london);
        System.out.println(kathmandu);

        // C)
        ZonedDateTime londonTime = ZonedDateTime.of(tomorrowTeaTime, london);
        System.out.println(londonTime);

        // D)
        ZonedDateTime kathmanduTime = londonTime.withZoneSameInstant(kathmandu);
        System.out.println(kathmanduTime);

        System.out.println(londonTime.getOffset());
        System.out.println(kathmanduTime.getOffset());


        // 3) Missing in practice doc from oracle.


        // 4)

        // A) Import DateTimeFormatter class.

        // B)
        String datePattern = "EE', 'd' of 'MMMM yyyy' at 'HH:mm z";

        // C)
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(datePattern, Locale.UK);
        System.out.println(dateFormat);

        // D)
        String timeTxt = dateFormat.format(kathmanduTime);
        System.out.println(timeTxt);
    }

}
