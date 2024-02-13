package org.example.lambda_expressions.learnTopics;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class APIFunctionalInterfaces {

    public void predicate() {
        Predicate<String> predicate = s -> s.contains("City");
        System.out.println("Using predicate - " + predicate.test("Vatican Citys"));
    }

    public void biPredicate() {
        BiPredicate<String,Integer> biPredicate = (str,len) -> str.length() == len;
        System.out.println("Using BiPredicate " + biPredicate.test("Hello Bro",29));
    }

    public void supplier() {
        Supplier<StringBuilder> supplier_first = StringBuilder::new;
        System.out.println("First case of using Supplier: " + supplier_first.get().append("February 11") );

        Supplier<LocalTime> supplier_second = LocalTime::now;
        System.out.println("Second case of using Supplier: " + supplier_second.get());
    }

    public void consumer() {
        Consumer<String> consumer = System.out::println;
        consumer.accept("First case of using consumer");

        List<String > names = new ArrayList<>();
        names.add("X");
        names.add("Y");
        names.add("Z");
        names.forEach(consumer);
    }

    public void biConsumer() {
        HashMap<String,String> mapCapabilities = new HashMap<String,String>();

        BiConsumer<String,String> biConsumer = mapCapabilities::put;

        biConsumer.accept("Basketball","Lebron James");
        biConsumer.accept("Football","Cristiano Ronaldo");

        System.out.println(mapCapabilities);

    }

    public void function() {
        Function<String,Integer> function = String::length;
        System.out.println("Using Function, Length of String : " + function.apply("Santa-Klaus"));
    }

    public void biFunction() {
        BiFunction<String,String,Integer> biFunction = (x,y) -> x.concat(y).length();

        System.out.println("Using BiFunction, Length of concatenated strings are: " + biFunction.apply("Santa-","Klaus"));
    }


    public void unaryOperator() {
        UnaryOperator<String> unaryOperator = name -> "My name is " + name;
        System.out.println(unaryOperator.apply("Ilia"));
    }

    public void binaryOperator() {
        BinaryOperator<String> binaryOperator = (name,age) -> "My name is " + name + ". I am " + age + " years old.";
        System.out.println(binaryOperator.apply("Ilia","21"));
    }

    public static void main(String[] args) {
        APIFunctionalInterfaces apiFunctionalInterfaces = new APIFunctionalInterfaces();
        apiFunctionalInterfaces.predicate();
        apiFunctionalInterfaces.biPredicate();
        apiFunctionalInterfaces.supplier();
        apiFunctionalInterfaces.consumer();
        apiFunctionalInterfaces.biConsumer();
        apiFunctionalInterfaces.function();
        apiFunctionalInterfaces.biFunction();
        apiFunctionalInterfaces.unaryOperator();
        apiFunctionalInterfaces.binaryOperator();
    }
}
