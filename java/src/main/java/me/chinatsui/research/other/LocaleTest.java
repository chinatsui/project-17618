package me.chinatsui.research.other;

import java.util.Arrays;
import java.util.Locale;

public class LocaleTest {

    public static void main(String[] args) {
//        Locale[] locales = Locale.getAvailableLocales();
//
//        for (Locale locale : locales) {
//            System.out.println(locale);
//        }
        String country = "DK";

        Locale[] locales = Locale.getAvailableLocales();

        for (Locale locale : locales) {
            if (locale.getCountry().equals(country)) {
                System.out.println(locale.getLanguage());
                System.out.println("UTC");
            }
        }

        System.out.println(Arrays.toString(Locale.getISOCountries()));


    }

}
