package org.example.concurrency;

import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        Future<Integer> future = es.submit(() -> 3 + 5);

        try {
            System.out.println("The answer is: " +  future.get(500, TimeUnit.MILLISECONDS));
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        }

        es.shutdown();

    }
}
