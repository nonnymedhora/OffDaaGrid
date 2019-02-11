package com.bawaweb.testing;
import java.util.*;


public class TestLocales {
    public TestLocales() {
    }

    public static void main(String[] args) {
        TestLocales testLocales = new TestLocales();
        Locale[] locales = Locale.getAvailableLocales();
            
        for (int i=0; i<locales.length; i++) {
            // Get the 2-letter language code
            String language = locales[i].getLanguage();
            String displayLanguage = locales[i].getDisplayLanguage();
        
            // Get the 2-letter country code; may be equal to ""
            String country = locales[i].getCountry();
            String displayCountry = locales[i].getDisplayCountry();
        
            // Get localized name suitable for display to the user
            String locName = locales[i].getDisplayName();
            
            System.out.println("\n_____________\nlanguage " + language);
            System.out.println("displaylanguage " + displayLanguage);
            System.out.println("country " + country);
            System.out.println("displaycountry " + displayCountry);
            System.out.println("locname " + locName);
        }
        
        System.out.println("\n___DEFAULT LOCALE\n__");
        // Get default locale
        Locale locale = Locale.getDefault();
        // Get the 2-letter language code
        String language = locale.getLanguage();
        String displayLanguage = locale.getDisplayLanguage();
        
        // Get the 2-letter country code; may be equal to ""
        String country = locale.getCountry();
        String displayCountry = locale.getDisplayCountry();
        
        // Get localized name suitable for display to the user
        String locName = locale.getDisplayName();
        
        System.out.println("DEF language " + language);
        System.out.println("DEF displayLanguage " + displayLanguage);
        System.out.println("DEF country " + country);
        System.out.println("DEF displayCountry " + displayCountry);
        System.out.println("DEF locname " + locName);
        
    }
}
