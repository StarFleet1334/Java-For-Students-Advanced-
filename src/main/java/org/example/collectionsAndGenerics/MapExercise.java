package org.example.collectionsAndGenerics;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 *
 *  HashMap
 *      -> Unsorted,UnOrdered Map
 *      -> It uses Hashcode of the object when inserting
 *      -> It allows null keys and multiple null values
 *
 *  HashTable
 *      -> Is similar to hashMap but is slower and
 *      -> It does not allow nulls and also is thread-safe
 *
 *
 *
 */


public class MapExercise {

    public static void main(String[] args) {

        Map<String,Integer> map = new TreeMap<>(); // Sorted by Keys
        map.put("John",10);
        map.put("Mary",21);
        map.put("Chris",33);
        System.out.println(map.containsKey("John")); // true
        System.out.println(map.containsValue(18)); // false
        System.out.println(map.containsValue(21)); // true
        System.out.println(map.isEmpty()); // false
        System.out.println(map.get("Chris")); // 33
        for (String name : map.keySet()) {
            System.out.println(name);
        }
        for (Integer age : map.values()) {
            System.out.println(age);
        }

        System.out.println(map.size()); // 3
        map.clear();
        System.out.println(map.size()); // 0
        map.put("John",10);
        map.put("Mary",21);
        map.put("Chris",33);

        map.forEach((x,y) -> System.out.println(x + " : " + y));
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " " + stringIntegerEntry.getValue());
        }


        Set keys = map.keySet();
        map.put("Mike",null); // [Chris=33,John=18,Mary=21,Mike=null]
        map.putIfAbsent("Chris",99); // [Chris=33,John=18,Mary=21,Mike=null]
        map.putIfAbsent("Mike",55); // [Chris=3,John=18,Mary=21,Mike=55]
        map.putIfAbsent("Luke",31); // [Chris=3,John=18,Luke=31,Mary=21,Mike=55]
        System.out.println(keys);

    }

}
