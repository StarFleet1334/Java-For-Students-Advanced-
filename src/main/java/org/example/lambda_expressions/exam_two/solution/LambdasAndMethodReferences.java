package org.example.lambda_expressions.exam_two.solution;

import java.util.*;
import java.util.function.*;

public class LambdasAndMethodReferences {

    public static void main(String[] args) {
        LambdasAndMethodReferences lambdasAndMethodReferences = new LambdasAndMethodReferences();
//        lambdasAndMethodReferences.staticMR();
//        lambdasAndMethodReferences.boundMR();
//        lambdasAndMethodReferences.unboundMR();
        lambdasAndMethodReferences.constructorMR();
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


    // Task 3

    public void unboundMR() {
        Predicate<String> predicate_lambda = (x) -> x.isEmpty();
        System.out.println("Using Lambda version: " + predicate_lambda.test(""));
        System.out.println("Using Lambda version: " + predicate_lambda.test("xyz"));

        Predicate<String> predicate_reference = String::isEmpty;
        System.out.println("Using Reference version: " + predicate_reference.test(""));
        System.out.println("Using Reference version: " + predicate_reference.test("xyz"));

        BiPredicate<String,String> biPredicateLambda = (x,y) -> x.startsWith(y);
        System.out.println("Using Lambda version on BiPredicate: " + biPredicateLambda.test("Mr. Joe Blogss","Mr."));
        System.out.println("Using Lambda version on BiPredicate: " + biPredicateLambda.test("Mr. Joe Blogss","Ms."));

        BiPredicate<String,String> biPredicateReference = String::startsWith;
        System.out.println("Using Lambda version on BiPredicate: " + biPredicateReference.test("Mr. Joe Blogss","Mr."));
        System.out.println("Using Lambda version on BiPredicate: " + biPredicateReference.test("Mr. Joe Blogss","Ms."));

    }

    // Task 4

    public void constructorMR() {
        Supplier<List<String>> supplier_lambda = () -> new ArrayList<>();
        List<String> list = supplier_lambda.get();
        list.add("Lambda");
        System.out.println(list);

        Supplier<List<String>> supplier_reference = ArrayList::new;
        list = supplier_reference.get();
        list.add("Lambda");
        System.out.println(list);

        Function<Integer,List<String>> function_lambda = (x) -> new ArrayList<>(x);
        list = function_lambda.apply(10);
        list.add("Lambda");
        System.out.println(list);

        Function<Integer,List<String>> function_reference = ArrayList::new;
        list = function_reference.apply(10);
        list.add("Lambda");
        System.out.println(list);
    }
}
