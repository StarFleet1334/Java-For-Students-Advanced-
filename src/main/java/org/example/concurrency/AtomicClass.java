package org.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *
 *  We cannot guarantee that a thread will stay running throughout the atomic
 *  operation, but we can guarantee that even if the thread moves in and out of the
 *  running state, no other thread can come in and act on the same data.
 *
 *  AtomicInteger,AtomicLong,AtomicBoolean
 *
 *
 */

public class AtomicClass {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        // Gotcha is like this if we use singleThreadExecutor
        // Order will be as we wish 0,1,2,3,4,5,6,7,8,9,10
        ExecutorService ts = Executors.newSingleThreadExecutor();

        // but if we use with multiple threads, the order will be
        // non-deterministic
//        ExecutorService ts = Executors.newFixedThreadPool(4);

        for (int i = 0; i <= 10; i++) {
            // We do not see a duplicates cause we use atomicInteger
            ts.submit(() -> System.out.println(atomicInteger.getAndIncrement()));
        }
        ts.shutdown();
    }
}
