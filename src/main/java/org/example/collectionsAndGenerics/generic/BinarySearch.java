package org.example.collectionsAndGenerics.generic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        searchCats();
    }

    public static void searchStrings() {
        List<String> names = Arrays.asList("John","Martin","Paula","Ann");
        Collections.sort(names);
        System.out.println(names);
        System.out.println(Collections.binarySearch(names,"Paula"));
        System.out.println(Collections.binarySearch(names,"Ilia"));
        // Since ilia is not in the list, it will check where it would be in
        // in the sorted list and it would be on index 1, so reverse -1 - 1 = -2
    }

    public static void searchCats() {
        Cat fluffy = new Cat("Fluffy",1);
        Cat bella = new Cat("Bella",5);
        List<Cat> cats = Arrays.asList(fluffy,bella);

        Collections.sort(cats); // Natural ordering, names ascending order
        System.out.println(cats);
        /*
        The list must be sorted in ascending order using natural ordering
        otherwise results would be undefined. if the list contains multiple elements
        equal to specified object, there is no guarantee which one will be found.
         */
        System.out.println("Bella is at index: " + Collections.binarySearch(cats,bella));

        // Using Comparator
        Comparator<Cat> byAge = (cat1,cat2) -> cat1.getAge() - cat2.getAge();
        Collections.sort(cats,byAge);
        System.out.println(cats);;
        System.out.println("Bella is at index: " + Collections.binarySearch(cats,bella,byAge));


    }
}

