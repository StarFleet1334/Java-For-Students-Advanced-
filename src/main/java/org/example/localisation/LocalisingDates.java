package org.example.localisation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 *
 *  Date formats vary by locale
 *
 *  -> DateTimeFormatter contains factory methods to obtain
 *  formatters for dates ( and times) for current locale.
 *      - DateTimeFormatter.ofLocalizedDate(dateStyle)
 *      - DateTimeFormatter.ofLocalizedDate(timeStyle)
 *      - DateTimeFormatter.ofLocalizedDateTime(dateTimeStyle)
 *  To customise for a specific locale, append withLocale(locale).
 *
 *
 */

public class LocalisingDates {

    public static void main(String[] args) {
        Locale locUS = Locale.US;
        Locale locFrench = new Locale("fr","FR");
        Locale locGerman = Locale.GERMAN;

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);


        DateTimeFormatter dateMediumStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(dateMediumStyle.withLocale(locUS).format(ldt));
        System.out.println(dateMediumStyle.withLocale(locGerman).format(ldt));

        DateTimeFormatter timeShortStyle = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(timeShortStyle.withLocale(locUS).format(ldt));
        System.out.println(timeShortStyle.withLocale(locFrench).format(ldt));

        DateTimeFormatter dateTimeStyle = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(dateTimeStyle.withLocale(locUS).format(ldt));
        System.out.println(dateTimeStyle.withLocale(locFrench).format(ldt));


    }
}
