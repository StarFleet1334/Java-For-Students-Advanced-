package org.example.localisation;

import java.util.Locale;

/**
 *
 *  Localisation involves ensuring that your program is adaptable to the
 *  location from which it is being executed.
 *
 *  This involves translating strings, use of different spellings and formatting of
 *  dates/numbers for that locale.
 *
 *  A locale, in its simplest terms, is a language/country pairing.
 *
 *  -> To create/select a locale that is not the default locale, there are 3 popular options:
 *      - constructors:
 *          pass in a language only or both a language and a country
 *      - built-in constants:
 *          the Locale class provides constants for the most popular locales
 *      - builder design pattern:
 *          flexible -specify the properties you want, in any order
 *          local is built at the end
 *
 *
 *
 *
 */

public class CreatingLocals {

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        // In my case it prints en_GE which means it uses english
        // and location is georgia

        // 1. constructors
        System.out.println(new Locale("en"));
        Locale englishGB = new Locale("en","GB");
        System.out.println(englishGB.getDisplayLanguage());
        System.out.println(englishGB.getDisplayCountry());


        // 2. Built-in constants
        System.out.println(Locale.FRENCH);

        // 3. Locale.Builder() pattern
        Locale locArabicEgypt = new Locale.Builder()
                .setLanguage("ar")
                .setRegion("EG")
                .build();
        System.out.println(locale);

    }
}
