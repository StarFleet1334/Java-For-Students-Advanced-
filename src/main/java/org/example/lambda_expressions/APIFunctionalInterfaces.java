package org.example.lambda_expressions;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class APIFunctionalInterfaces {

    public void predicate() {
        Predicate<String> predicate = s -> s.contains("City");
        System.out.println("Using predicate - " + predicate.test("Vatican Citys"));
    }

    public void biPredicate() {
        BiPredicate<String,Integer> biPredicate = (str,len) -> str.length() == len;
        System.out.println("Using BiPredicate " + biPredicate.test("Hello Bro",29));
    }

    public static void main(String[] args) {
        APIFunctionalInterfaces apiFunctionalInterfaces = new APIFunctionalInterfaces();
        apiFunctionalInterfaces.predicate();
        apiFunctionalInterfaces.biPredicate();
    }
}
