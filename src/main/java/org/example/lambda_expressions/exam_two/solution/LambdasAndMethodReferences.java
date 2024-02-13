package org.example.lambda_expressions.exam_two.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdasAndMethodReferences {

    public static void main(String[] args) {
        LambdasAndMethodReferences lambdasAndMethodReferences = new LambdasAndMethodReferences();
//        lambdasAndMethodReferences.staticMR();
        lambdasAndMethodReferences.boundMR();
    }

    // Task 1
    public void staticMR() {
        List<Integer> lst = Arrays.asList(1,2,7,5,4);
        Consumer<List<Integer>> consumer_lambda = list -> Collections.sort(list);
        consumer_lambda.accept(lst);
        System.out.println(lst);
        lst = Arrays.asList(1,2,7,5,4);
        Consumer<List<Integer>> consumer_reference = Collections::sort;
        consumer_reference.accept(lst);
        System.out.println(lst);
    }

    // Task 2
    public void boundMR() {
        String name = "Mr. Joe Bloggs";
        Predicate<String> predicate_lambda = (x) -> name.startsWith(x);
        System.out.println("Using Lambda version: " + predicate_lambda.test("Mr."));
        System.out.println("Using Lambda version: " + predicate_lambda.test("Ms."));

        Predicate<String> predicate_reference = name::startsWith;
        System.out.println("Using Reference version: " + predicate_reference.test("Mr."));
        System.out.println("Using Reference version: " + predicate_reference.test("Ms."));
    }

}
