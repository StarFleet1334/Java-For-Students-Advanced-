package org.example.streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {


        // Terminal Operation - min
        Optional<String > optional_min = Stream.of("deer","horse","pig","balloon","sun","it")
                .min(Comparator.comparingInt(String::length));
        System.out.println("Element with minimal length: " + optional_min.get());

        // Terminal Operation - max
        Optional<String > optional_max = Stream.of("deer","horse","pig","balloon","sun","it")
                .max(Comparator.comparingInt(String::length));
        System.out.println("Element with maximal length: " + optional_max.get());
    }
}
