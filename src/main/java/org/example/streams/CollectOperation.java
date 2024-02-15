package org.example.streams;


import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectOperation {

    public static void main(String[] args) {

        // Terminal Operator - Collect
        StringBuilder word = Stream.of("ad","jud","i","cate")
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append
                );
        System.out.println(word);


        String s = Stream.of("cake","biscurits","apple tartt")
                .collect(Collectors.joining(" "));
        System.out.println(s);

        // Collectors.toMap()

        Map<String,Integer> map = Stream.of("Apple","Banana","Mango","Peach")
                .collect(Collectors.toMap(
                        x -> x, // Key Mapper
                        String::length // Value Mapper
                ));
        System.out.println(map);

        // What if we have duplicate keys in Map ?
        Map<Integer,String> map_duplicate = Stream.of("Apple","Banana","Mango","Peach")
                .collect(Collectors.toMap(
                        String::length,
                        x -> x,
                        (x,y) -> x + ", "  + y
                ));
        System.out.println(map_duplicate);

        // TreeMap

        TreeMap<String,Integer> treeMap = Stream.of("Apple","Banana","Mango","Peach","Banana","Banana")
                .collect(Collectors.toMap(
                        a -> a,
                        String::length,
                        Integer::sum,
                        TreeMap::new
                ));

        System.out.println(treeMap);

    }
}
