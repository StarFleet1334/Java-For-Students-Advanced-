package org.example.lambda_expressions;

import java.util.function.Predicate;

interface Evaluate<T> {
    boolean isNegative(T t);
}

public class TestPredicate {

    public static void main(String[] args) {
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("First Evaluation using Evaluate (functional interface): " + lambda.isNegative(10));
        System.out.println("Second Evaluation using Evaluate (functional interface): " + lambda.isNegative(-10));

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("First Evaluation using Predicate (functional interface): " + predicate.test(10));
        System.out.println("Second Evaluation using Predicate (functional interface): " + predicate.test(-10));

    }
}
