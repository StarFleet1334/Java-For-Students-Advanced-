package org.example.streams.primtive_streams;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreatePrimitiveStreams {

    public static void main(String[] args) {

        int[] iArr = {1,2,3};
        double[] dArr = {1.1,2.2,3.3};
        long[] lArr = {1L,2L,3L};

        IntStream intStream = Arrays.stream(iArr);
        DoubleStream doubleStream = Arrays.stream(dArr);
        LongStream longStream = Arrays.stream(lArr);

        System.out.println(intStream.count() + " " + doubleStream.count() + " " + longStream.count());

        IntStream intStream1 = IntStream.of(1,2,3);
        DoubleStream doubleStream1 = DoubleStream.of(1.1,2.2,3.3);
        LongStream longStream1 = LongStream.of(1L,2L,3L);

        System.out.println(intStream1.count() + " " + doubleStream1.count() + " " + longStream1.count());


        // Primitive Streams in addition to containing many of streams methods, also
        // contain specialised method for working with numeric data, such as:
        // min(), max(), sum(), average()

        int sum = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .mapToInt(x -> x)// unbox
                .sum();
        System.out.println("Sum using primitive Stream: " + sum);

        int sum1 = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .reduce(0, Integer::sum);
        System.out.println("Sum using standard stream: " + sum1);
    }
}
