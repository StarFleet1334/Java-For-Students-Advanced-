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


        int x = 4;
        System.out.println("Is " + x + " even ? " + check(x,n -> n % 2 == 0));
        x = 7;
        System.out.println("Is " + x + " even ? " + check(x,n -> n % 2 == 0));

    }

    public static <T> boolean check(T t,Predicate<T> lambda) {
        return lambda.test(t);
    }

}
