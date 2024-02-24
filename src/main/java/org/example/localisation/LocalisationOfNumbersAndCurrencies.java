package org.example.localisation;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 *  Currencies and numbers differ between locales.
 *
 *  -> The NumberFormat class has several static factory methods that enable us
 *  in both directions i.e. from a String to a number and a number to a String.
 *      - getInstance(), getInstance(locale)
 *      - getNumberInstance(), getNumberInstance(locale),
 *      - getCurrencyInstance(), getCurrencyInstance(locale)
 *
 *  -> Once you have the NumberFormat instance you require, you can invoke format() to
 *  convert a number to a String and parse() to convert a String into a number.
 *
 *
 *
 */

public class LocalisationOfNumbersAndCurrencies {
    public static void main(String[] args) {
        formatNumbers();
        formatCurrencies();
        parseNumbers();
        parseCurrencies();
    }

    private static void parseCurrencies() {
        // String to a number
        String georgianCurrency = "GEL23.22";
        String unitedStatesCurrency = "$23.22";
        String italianCurrency = "23,22 €";
        String ukCurrency = "£23.22";

        try {
            System.out.println(NumberFormat.getCurrencyInstance().parse(georgianCurrency));
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).parse(unitedStatesCurrency));
            System.out.println(NumberFormat.getCurrencyInstance(Locale.ITALY).parse(italianCurrency));
            System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).parse(ukCurrency));

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void parseNumbers() {
        // string to a number
        String unitedStatesNumber= "77,000.11";
        String italianNumber = "77.000,11";
        String frenchNumber = "77 000,11";
        try {
            System.out.println(NumberFormat.getNumberInstance(Locale.US).parse(unitedStatesNumber));
            System.out.println(NumberFormat.getNumberInstance(Locale.ITALY).parse(italianNumber));
            System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).parse(frenchNumber));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void formatCurrencies() {
        // Number to a string
        double n = 23.22;
        System.out.println(NumberFormat.getCurrencyInstance().format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.ITALY).format(n));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).format(n));

    }

    private static void formatNumbers() {
        // Number to a String
        double n = 77_000.11;
        System.out.println(NumberFormat.getInstance().format(n));
        System.out.println(NumberFormat.getNumberInstance(Locale.US).format(n));
        System.out.println(NumberFormat.getNumberInstance(Locale.ITALY).format(n));
        System.out.println(NumberFormat.getNumberInstance(Locale.FRANCE).format(n));

    }
}
