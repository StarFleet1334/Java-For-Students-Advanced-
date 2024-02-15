package org.example.streams.primtive_streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappingPrimitiveStreams {

    public static void mappingPrimitiveStreams() {

        // IntStream to Stream<T>
        Stream<String> stream = IntStream.of(1,2,3)
                .mapToObj(x -> "Number: " + x);
        stream.forEach(System.out::println);
        System.out.println();

        // InStream to DoubleStream
        DoubleStream doubleStream = IntStream.of(1,2,3)
                .mapToDouble(n -> (double) n);
        doubleStream.forEach(System.out::println);
        System.out.println();

        // IntStream to IntStream
        IntStream.of(1,2,3)
                .map(x -> x * 2)
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
        mappingPrimitiveStreams();
    }
}
