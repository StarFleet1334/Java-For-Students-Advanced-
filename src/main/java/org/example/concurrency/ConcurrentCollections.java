package org.example.concurrency;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 *
 *
 * SkipListCollections:
 *  -> ConcurrentSkipListSet and ConcurrentSkipListMap are
 *      sorted concurrent collections.
 *
 *  sorted by natural order.
 *  ConcurrentSkipListSet is concurrent version of TreeSet
 *  ConcurrentSkipListMap is concurrent version of TreeMap
 *
 *
 *
 *
 *
 *
 */

public class ConcurrentCollections {

    public static void main(String[] args) {

        Set<String> countries = new ConcurrentSkipListSet<>();
        countries.add("Germany");
        countries.add("Canada");
        countries.add("Australia");
        for (String c: countries) {
            System.out.println(c);
        }

        Map<String,Integer> map = new ConcurrentHashMap<>();
        map.put("Jack",12);
        map.put("Zack",15);
        map.put("Anna",22);

        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }


    }
}
