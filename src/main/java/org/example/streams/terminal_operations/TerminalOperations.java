package org.example.streams.terminal_operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {


        // Terminal Operation - min -> Reduction (YES)
        Optional<String > optional_min = Stream.of("deer","horse","pig","balloon","sun","it")
                .min(Comparator.comparingInt(String::length));
        System.out.println("Element with minimal length: " + optional_min.get());

        // Terminal Operation - max -> Reduction (YES)
        Optional<String > optional_max = Stream.of("deer","horse","pig","balloon","sun","it")
                .max(Comparator.comparingInt(String::length));
        System.out.println("Element with maximal length: " + optional_max.get());


        // Terminal Operation - findAny -> Reduction (NO)
        Optional<String> optional_findAny = Stream.of("deer","horse","pig","balloon","sun","it").findAny();
        optional_findAny.ifPresent(s -> System.out.println("Result of finAny: " + s));

        // Terminal Operation - findFirst -> Reduction (NO)
        Optional<String> optional_findFirst = Stream.of("deer","horse","pig","balloon","sun","it").findFirst();
        optional_findFirst.ifPresent(s -> System.out.println("Result of finAny: " + s));

        List<String> tt = Arrays.asList("deer","horse","pig","balloon","sun","it");
        Predicate<String> predicate = x -> x.startsWith("p");
        System.out.println("AnyMatch result: " + tt.stream().anyMatch(predicate));
        System.out.println("AllMatch result:" + tt.stream().allMatch(predicate));
        System.out.println("NoneMatch result: " + tt.stream().noneMatch(predicate));

    }
}
