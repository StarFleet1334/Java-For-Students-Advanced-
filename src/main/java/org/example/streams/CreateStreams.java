package org.example.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CreateStreams {

    public static void main(String[] args) {

        List<String> animaList = Arrays.asList("Lion","Giraffee","Kanguroo","Tiger");
        long numberOfItemsInList = animaList.stream().count();
        System.out.println("Number of items in the list: " + numberOfItemsInList);


        Map<String,Integer> map = new HashMap<>();
        map.put("Ilia",21); map.put("Saba",19); map.put("Luka",21);
        long numberOfItemsInMap = map.entrySet().stream().count();
        System.out.println("Numer of items in the map: " + numberOfItemsInMap);

        // as a Path I indicated path from repository root
        printLinesFromFile("src/main/java/org/example/streams/cats.txt");


        // InFinite streams can be converted to finite streams using limit
        Stream
                .iterate(2,n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    public static void printLinesFromFile(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(line -> {
                String[] arr = line.split("/");
                System.out.println(arr[0] + " " + arr[1]);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
