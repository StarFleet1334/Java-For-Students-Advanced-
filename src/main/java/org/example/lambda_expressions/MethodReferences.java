package org.example.lambda_expressions;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

    public static void main(String[] args) {
        boundMethodReferences();
    }
}
