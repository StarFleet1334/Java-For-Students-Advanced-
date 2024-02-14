package org.example.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReduceOperation {

    public static void main(String[] args) {

        // Reduce with only BinaryOperator

        String name = Stream.of("I","L","I","A")
                .reduce("",(x,y) -> x + y)
                .toLowerCase();
        System.out.println("Result of reduce: " + name);

        int sumOfNumbersUntilTen = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .reduce(0, Integer::sum);
        System.out.println("Result of reduce: " + sumOfNumbersUntilTen);

        // Reduce with BiFunction + BinaryOperator

        Stream<String> stream = Stream.of("Sun","Moon","Wolf");
        int a = stream
                .reduce(1,
                        (n,str) -> n + str.length(),
                        (x,y) -> x + y);
        System.out.println(a);

        String[] array = {"one", "two", "three", "four","five"};
        String result = Arrays.stream(array)
                .reduce("",
                        (s, s2) -> s + "-" + s2,
                        (s, s2) -> s + "|" + s2);
        System.out.println(result);

        String result_parallel = Arrays.stream(array)
                .parallel()
                .reduce("",
                        (s, s2) -> s + "-" + s2,
                        (s, s2) -> s + "|" + s2);
        System.out.println(result_parallel);
    }
}
