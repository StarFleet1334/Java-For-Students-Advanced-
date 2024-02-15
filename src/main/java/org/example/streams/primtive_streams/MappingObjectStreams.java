package org.example.streams.primtive_streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MappingObjectStreams {

    public static void mappingObjectStreams() {
        // Stream<T> to Stream<T>

        Stream.of("ash","beech","sycamore")
                .map(String::toUpperCase)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();
        // Stream<T> to DoubleStream
        DoubleStream doubleStream = Stream.of("ash","beech","sycamore")
                .mapToDouble(String::length);
        doubleStream.forEach(x -> System.out.print(x + " "));
        System.out.println();
        // Stream<T> to IntStream
        IntStream intStream = Stream.of("ash","beech","sycamore")
                .mapToInt(String::length);
        intStream.forEach(x -> System.out.print(x + " "));
        System.out.println();
        // Stream<T> to LongStream
        LongStream longStream = Stream.of("ash","beech","sycamore")
                .mapToLong(String::length);
        longStream.forEach(x -> System.out.print(x + " "));


    }

    public static void main(String[] args) {
        mappingObjectStreams();
    }
}
