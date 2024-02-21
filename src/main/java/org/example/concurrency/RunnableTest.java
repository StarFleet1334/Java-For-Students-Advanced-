package org.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        // Here we execute runnable task asynchronously
        es.execute(() -> System.out.println("Runnable example"));

        // Here we shut down this app otherwise it will never terminate
        es.shutdown();
    }
}
