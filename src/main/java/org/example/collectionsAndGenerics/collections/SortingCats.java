package org.example.collectionsAndGenerics.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingCats {
    public static void main(String[] args) {
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat("Trixy",5));
        catList.add(new Cat("Bella",7));
        catList.add(new Cat("Bella",2));
        Comparator<Cat> comparator = Comparator
                .comparing(Cat::getName)
                .thenComparing(Cat::getAge);
        Collections.sort(catList,comparator);
        System.out.println(catList);
    }
}
