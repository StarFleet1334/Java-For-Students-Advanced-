package org.example.lambda_expressions;

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
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("First case of using consumer");

        List<String > names = new ArrayList<>();
        names.add("X");
        names.add("Y");
        names.add("Z");
        names.forEach(consumer);
    }

    public void biConsumer() {
        HashMap<String,String> mapCapabilities = new HashMap<String,String>();

        BiConsumer<String,String> biConsumer = (key,value) -> mapCapabilities.put(key,value);

        biConsumer.accept("Basketball","Lebron James");
        biConsumer.accept("Football","Cristiano Ronaldo");

        System.out.println(mapCapabilities);

    }

    public static void main(String[] args) {
        APIFunctionalInterfaces apiFunctionalInterfaces = new APIFunctionalInterfaces();
        apiFunctionalInterfaces.predicate();
        apiFunctionalInterfaces.biPredicate();
        apiFunctionalInterfaces.supplier();
        apiFunctionalInterfaces.consumer();
        apiFunctionalInterfaces.biConsumer();
    }
}
