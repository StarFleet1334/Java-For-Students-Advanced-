package org.example.localisation;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *                  Category enums
 *
 *  When you change the default locale with Locale.setDefault(0, certain options regarding display
 *  and formatting are set automatically.
 *
 *  We can set these options individually ourselves using the Locale.Category enums: DISPLAY and FORMAT.
 *      - DISPLAY - relates to display security_info
 *      - FORMAT - formatting currencies, dates and numbers.
 *
 */

public class LocaleCategoryEnums {
    public static void main(String[] args) {
        double n = 77_000.11;
        Locale french = new Locale("fr","FR");
        Locale locale = Locale.getDefault();
        System.out.println(locale.getDisplayName());
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayCountry());
        System.out.println(NumberFormat.getInstance().format(n));


        Locale.setDefault(Locale.Category.DISPLAY,french);

        System.out.println(locale.getDisplayName());
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayCountry());
        System.out.println(NumberFormat.getInstance().format(n));

        Locale.setDefault(Locale.Category.FORMAT,french);
        System.out.println(NumberFormat.getInstance().format(n));

    }
}
