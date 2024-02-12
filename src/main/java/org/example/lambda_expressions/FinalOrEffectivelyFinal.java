package org.example.lambda_expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FinalOrEffectivelyFinal {

    String name = "";


    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Moon");

        int x = 22;

//        int finalX = x; // This is Effectively final
        Predicate<String> predicate = s -> {
            // x++; // This would give us and error if we uncomment it in the lambda expression block
            new FinalOrEffectivelyFinal().name = "Ilia";
            System.out.println("x is equal to: " + x);
            return !s.isEmpty();
        };
        filterData(arrayList,predicate);
        System.out.println(arrayList);

       // x++; // This would give us and error if we uncomment it in the lambda expression block
    }

    public static void filterData(List<String> list, Predicate<String> predicate) {
        list.removeIf(s -> !predicate.test(s));
    }
}
