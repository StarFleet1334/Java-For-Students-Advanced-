package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {

    // To make a stream parallel we use parallel() or parallelStream() methods

    // parallel() is available in Stream<T>
    // parallelStream() is defined in the collection<E> interface

    public static void main(String[] args) {
        Stream<String> parallelStream = List.of("FirstAnimal","SecondAnimal")
                .parallelStream();

        Stream<String> parallel = Stream.of("FirstAnimal","SecondAnimal")
                .parallel();

        // Let's have a look at sequential stream that sums up numbers

        int sum_sequential = Stream.of(10,20,30,40,50,60)
                .mapToInt(x -> x)
                .sum();
        System.out.println("Sum using sequential stream: " + sum_sequential);

        int sum_parallel = Stream.of(10,20,30,40,50,60)
                .parallel()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum using parallel stream: " + sum_parallel);


        // Here is demonstrated order difference
        // So be careful using parallel if order is crucial
        sequentialStream();
        System.out.println();
        parallelStream();
    }

    public static void sequentialStream() {
        Arrays.asList("a","b","c")
                .stream()
                .forEach(System.out::print);
    }

    public static void parallelStream() {
        Arrays.asList("a","b","c")
                .stream()
                .parallel()
                .forEach(System.out::print);
    }
}
