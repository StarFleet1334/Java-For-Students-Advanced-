package org.example.collectionsAndGenerics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDogs {

    public static void main(String[] args) {
//        comparable(new Dog[]{new Dog("Sport",2),new Dog("Rover",7)});
//        comparable(Arrays.asList(new Dog("Spot",2),new Dog("Rover",7)));

        comparator(new Dog[]{new Dog("Sport",2),new Dog("Rover",7)});
        comparator(Arrays.asList(new Dog("Spot",2),new Dog("Rover",7)));
    }

    public static void comparable(Dog[] dogs) {
        Arrays.sort(dogs);
        System.out.println(Arrays.toString(dogs));
    }

    public static void comparable(List<Dog> dogList) {
        Collections.sort(dogList);
        System.out.println(dogList);
    }

    public static void comparator(Dog[] dogs) {
        Comparator<Dog> byAge = Comparator.comparing(dog -> dog.getAge());
        Arrays.sort(dogs,byAge);
        System.out.println(Arrays.toString(dogs));

        Comparator<Dog> ageReversed = Comparator.comparing(Dog::getAge).reversed();
        Arrays.sort(dogs,ageReversed);
        System.out.println(Arrays.toString(dogs));
    }

    public static void comparator(List<Dog> dogs) {
        Comparator<Dog> byAge = Comparator.comparing(Dog::getAge);
        Collections.sort(dogs,byAge);
        System.out.println(dogs);

        Comparator<Dog> ageReversed = Comparator.comparing(Dog::getAge).reversed();
        Collections.sort(dogs,ageReversed);
        System.out.println(dogs);
    }
}
