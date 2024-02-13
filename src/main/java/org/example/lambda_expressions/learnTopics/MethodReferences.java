package org.example.lambda_expressions.learnTopics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class MethodReferences {

    public static void boundMethodReferences() {
        // KeyNote - Instance type is known at the compile time

        // Example using Consumer

        String name = "Mr. Ilia";

        Supplier<String> lambda_first = () -> name.toLowerCase();
        Supplier<String> reference_first = name::toLowerCase;
        System.out.println("First Example: " + lambda_first.get());
        System.out.println("Second Example: " + reference_first.get());

        // Demonstrating why context is important

        Predicate<String> lambda_second = (key) -> name.startsWith(key);
        Predicate<String> reference_second = name::startsWith;

        System.out.println("Second Example: " + lambda_second.test("Mr."));
        System.out.println("Second Example: " + reference_second.test("Mr."));


        // Functionality StartsWith has overloaded method. check doc.

        Predicate<String> lambda_third = (key) -> name.startsWith(key,4);

        // This case context is crucial, that's why answer is false. obv you can use any other FI
        Predicate<String> reference_fourth = name::startsWith;

        System.out.println("Third Example: " + lambda_third.test("I"));
        System.out.println("Third Example: " + reference_fourth.test("I"));

    }

    public static void unBoundedMethodReference() {
        // keyNote - Instance type is provided at run time

        Function<String,Integer> lambda_first = (name) -> name.length();
        Function<String,Integer> reference_first = String::length;

        System.out.println("First Example: " + lambda_first.apply("Ilia"));
        System.out.println("Second Example: " + reference_first.apply("Ilia"));


        BiFunction<String, String,Integer> lambda_second = (firstName,lastName) -> (firstName.concat(lastName)).length();
//        BiFunction<String,String,Integer> reference_second = String::concat; // This cannot happen
        BiFunction<String,String,String> reference_second = String::concat;
        System.out.println("Second Example: " + lambda_second.apply("Ilia","Lataria"));
        System.out.println("Second Example: " + reference_second.apply("Ilia","Lataria"));
    }

    public static void staticMethodReference() {
        // Static Method reference is still unbounded
        Consumer<List<Integer>> lambda_first = (lst) -> Collections.sort(lst);
        Consumer<List<Integer>> reference_first = Collections::sort;

        List<Integer> lst = Arrays.asList(2,1,5,4,9);
        lambda_first.accept(lst);
        System.out.println(lst);

        List<Integer> lst2 = Arrays.asList(8,12,4,3,7);
        reference_first.accept(lst2);
        System.out.println(lst2);
    }


    public static void constructorMethodReference() {
        Supplier<StringBuilder> lambda_first = () -> new StringBuilder();
        Supplier<StringBuilder> reference_first = StringBuilder::new;

        StringBuilder first = lambda_first.get().append("Ilia").append(" Lataria");
        System.out.println(first);
        StringBuilder second = reference_first.get().append("Ilia").append(" Lataria");
        System.out.println(second);
    }

    public static void main(String[] args) {
//        boundMethodReferences();
//        staticMethodReference();
        constructorMethodReference();
    }
}
