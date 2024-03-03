package org.example.twoOne_record_patterns;

import java.util.Locale;

record GPSPoint(double latitude,double longitude) {}

record Location(String name,GPSPoint gpsPoint) {}



public class MoreExamples {

    public void check(Object o) {
        // type pattern
        if (o instanceof Location location) {
            System.out.println(STR."\{location.name()} - \{location.gpsPoint()}");
        }
            // as you see here we use LVTI
        // decoupling components
        if (o instanceof Location(var name,var gpsPoint)) {
            System.out.println(STR."\{name} - \{gpsPoint}");
        }
        
        // decoupling on nested level

        if (o instanceof Location(var name,GPSPoint(var latitude,var longitude))) {
            System.out.println(STR."\{name} - \{latitude} \{longitude}");
        }
    }

    public static void main(String[] args) {
        Location location = new Location(
                "Kutaisi Internation University",
                new GPSPoint(
                        22.2,
                        33.1
                )
        );
        MoreExamples moreExamples = new MoreExamples();
        moreExamples.check(location);
    }
}
