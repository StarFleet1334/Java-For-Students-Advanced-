package org.example.collectionsAndGenerics.exam.solution;

import java.util.*;

public class MapToMaps {
    public static void main(String[] args) {
        mapsToMaps();
    }
    public static void mapsToMaps() {
        Map<String, Integer> channelToSubscribers = new TreeMap<>(); // channel, numSubscribers
        Map<String, String> channelToPublisher = new TreeMap<>(); // channel, publisher
        Map<String, Integer> publisherToSubscribers = new TreeMap<>(); // publisher, numSubscribers

        // channel -> number of subscribers
        // K -> V1
        channelToSubscribers.put("JustForLaughs", 120_000);
        channelToSubscribers.put("JustForGags", 10_000);
        channelToSubscribers.put("ContemplationTechniques", 10_000);
        channelToSubscribers.put("A New Earth", 20_000);

        // channel -> publisher
        // K -> V2
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");

        // 1. Setup "publisherToSubscribers"
        // publisher -> number of subscribers (total)
        // V2 -> V1
        channelToSubscribers.forEach(
                (x,y) ->  {
                    String publisher = channelToPublisher.get(x);
                    publisherToSubscribers.put(
                            publisher,
                            y + publisherToSubscribers.getOrDefault(publisher,0)
                    );

                }
        );


        // 2. Output "publisherToSubscribers"
        publisherToSubscribers.forEach(
                (x,y) -> System.out.println("Publisher: " + x + "; numSubscribers: " + y)
        );

        // 3. Who has the most/least subscribers?
        Optional<Map.Entry<String, Integer>> min = publisherToSubscribers.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue));
        Optional<Map.Entry<String, Integer>> max = publisherToSubscribers.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue));
        System.out.println("Publisher with most subscribers: " + max.get().getKey() + " " + max.get().getValue());
        System.out.println("Publisher with fewest subscribers: " + min.get().getKey() + " " + min.get().getValue());
    }
}
