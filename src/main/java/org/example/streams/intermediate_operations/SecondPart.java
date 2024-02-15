package org.example.streams.intermediate_operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SecondPart {

    public static void main(String[] args) {

        // Intermediate operation - Map
        // Map uses functional method: R apply(T t)

        Stream.of("book","pen","ruler")
                .map(String::length)
                .forEach(System.out::print);

        // Intermediate operation - flatMap
        // takes each element in the stream and makes any elements it contains
        // in a single stream e.g. Stream<String>

        System.out.println();
        List<String> list1 = Arrays.asList("sean","desmond");
        List<String> list2 = Arrays.asList("mary","ann");
        Stream<List<String>> stream = Stream.of(list1,list2);

        stream.flatMap(x -> x.stream())
                .forEach(System.out::print);

        System.out.println();


        // Intermediate operation - sorted()
        // returns a stream with elements sorted
        // It is a stateful intermediate operation; it needs to see all of the data
        // before it can sort it

        Stream.of("Tim","Jim","Peter","Ann","Mary")
                .peek(name -> System.out.println(" 0. " + name))
                .filter(name -> name.length() == 3)
                .peek(name -> System.out.println(" 1. " + name))
                .sorted()
                .peek(name -> System.out.println(" 2. " + name))
                .limit(2)
                .forEach(x -> System.out.println(" 3. " + x));

    }
}
