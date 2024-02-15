package org.example.streams.terminal_operations;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsGroupingBy {

    public static void main(String[] args) {

        // Grouping by tells collect() to group all of the elements into a Map

        // Group by a length of string
        Stream<String> names = Stream.of("Joe","Tom","Tom","Alan","Peter");

        Map<Integer, List<String>> groupByLength = names.collect(
                Collectors.groupingBy(String::length)
        );
        System.out.println(groupByLength);

        // Grouping By is overloaded to allow us to pass down a "downstream collector".
        // This is a collector that does something special with the values

        // Fun fact once you can not use names here again cause
        // Stream has already been linked or consumer
//        Map<Integer, Set<String>> setMap = names
//                .collect(
//                        Collectors.groupingBy(
//                                String::length,
//                                Collectors.toSet()
//                        )
//                );
//        System.out.println(setMap);

        Map<Integer, Set<String>> setMap = Stream.of("Joe","Tom","Tom","Alan","Peter")
                .collect(
                        Collectors.groupingBy(
                                String::length,
                                Collectors.toSet()
                        )
                );
        System.out.println(setMap);

        TreeMap<Integer,List<String>> treeMap = Stream.of("Joe","Tom","Tom","Alan","Peter")
                .collect(
                        Collectors.groupingBy(
                                String::length,
                                TreeMap::new,
                                Collectors.toList()
                        )
                );

        System.out.println(treeMap);



    }
}
