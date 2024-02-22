package org.example.concurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 *
 * We can get a synchronized version of a non-concurrent collection
 * using the Collections utility class
 *
 * -> Useful if you are given an existing non-concurrent collection and you want to share
 * it among several threads.
 *
 * -> synchronized collections also throw ConcurrentModificationException if you try to modify
 * them inside a loop.
 *
 */

public class SynchronizedCollections {

    public static void main(String[] args) {
        // Non-concurrent collection
//        Map<String,String> capitalCities = new HashMap<>();
        Map<String,String> capitalCities = new ConcurrentHashMap<>();

        capitalCities.put("Oslo","Norway");
        capitalCities.put("Copenhagen","Denmark");

        Map<String,String> syncCapitalCities = Collections.synchronizedMap(capitalCities);

        for (String key: syncCapitalCities.keySet()) {
            System.out.println("Key: " + key + " - value: " + syncCapitalCities.get(key));
            // if on non-concurrent collections we use remove(key)
            // it would give us ConcurrentModificationException
            // To fix that instead of non-concurrent map we use concurrent
            syncCapitalCities.remove(key);
        }

    }
}
