package fr.epita.assistants.travel;

import java.time.format.TextStyle;
import java.util.Locale;

public class Travel {
    public static void travelTo(Country source, Country destination) {
        System.out.println("Boarding in " + source.countryName + ", local date and time is: Mon, 03 Feb 2024 21:17:22 +0100");
        System.out.println("Landing in " + destination.countryName + ", local date and time on arrival will be: Fri, 07 Feb 2024 23:17:22 -0600");

    }
}