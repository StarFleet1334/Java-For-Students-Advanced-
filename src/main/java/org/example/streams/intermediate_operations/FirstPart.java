package org.example.streams.intermediate_operations;

import java.util.stream.Stream;

public class FirstPart {

    public static void main(String[] args) {

        // Intermediate operation - Filter

        Stream.of("Galway","Mayo","Roscommon")
                .filter(x -> x.length() > 5)
                .forEach(System.out::println);

        // Intermediate operation - Distinct
        // In here equals() is used which is case-sensitive

        Stream.of("eagle","House","eagle","EAGLE")
                .peek(s -> System.out.println(" 1. " + s))
                .distinct() // So as we see from the result it remembers previous
                .forEach(s -> System.out.println(" 2. " + s));

        // Intermediate operation - Limit
        // It is short-circuiting it means that it will stop when the limit is reached
        System.out.println();
        Stream.of(11,22,33,44,55,66,77,99,99)
                .peek(n -> System.out.println(" A - " + n))
                .filter(x -> x > 40)
                .peek(n -> System.out.println(" B - " + n))
                .limit(2)
                .forEach(x -> System.out.println(" C - " + x));

    }
}
