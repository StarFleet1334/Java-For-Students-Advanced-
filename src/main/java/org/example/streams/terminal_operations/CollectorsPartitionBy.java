package org.example.streams.terminal_operations;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsPartitionBy {


    public static void main(String[] args) {

        // Partitioning is special type of grouping where
        // keys are true and false

        Map<Boolean, List<String>> map = Stream.of("Anna","Jacob","Bob","Rebecca","Billy")
                .collect(
                        Collectors.partitioningBy(s -> s.startsWith("B"))
                );
        System.out.println(map);


        Map<Boolean,Set<String>> setMap = Stream.of("Anna","Jacob","Bob","Rebecca","Billy")
                .collect(
                        Collectors.partitioningBy(s -> s.length() > 5,
                                Collectors.toSet())
                );
        System.out.println(setMap);


    }
}
