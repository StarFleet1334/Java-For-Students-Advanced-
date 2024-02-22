package org.example.concurrency;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 *  CopyOnWrite Collections:
 *      -> CopyOnWriteArrayList and CopyOnWriteArraySet
 *
 *  CopyOnWrite Collections are suitable for situations where you read a lot
 *  but write very little.
 *
 *  WHen an object is added to or deleted from the collection, copy is made of the
 *  entire collection. Not talking about the object state that the references held in
 *  the collection refer to but we are talking about the references themselves
 *
 *
 *
 */



public class CopyOnWriteCollections {

    public static void main(String[] args) {
        List<String> names = new CopyOnWriteArrayList<>();
        names.add("Ann");
        names.add("Brian");
        names.add("Carol");

        for (String name : names) {
            System.out.println(name);
            // So name is added into a copy
            names.add(name);
        }
        System.out.println(names);
        System.out.println("----------------------------------");


        Set<String > uniqueNames = new CopyOnWriteArraySet<>();
        uniqueNames.add("Ann");
        uniqueNames.add("Brian");
        uniqueNames.add("Carol");

        for (String name : uniqueNames) {
            System.out.println(name);
            // So name is added into a copy
            uniqueNames.add(name);
        }
        System.out.println(uniqueNames);
    }
}
