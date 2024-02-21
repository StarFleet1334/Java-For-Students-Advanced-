package org.example.concurrency;

import java.util.concurrent.*;

/**
 *
 * Executors exists that enable us to schedule tasks to be performed at some time
 * in the future.
 *
 * In addition, tasks can be scheduled to occur repeatedly at a particular interval.
 *
 * To create scheduled executors, use the Executors utility class:
 *  -> ScheduledExecutorService newSingleThreadScheduleExecutor()
 *  -> ScheduledExecutorService newScheduledThreadPool()
 *
 *
 *
 *
 *
 *
 */

public class ScheduleTasks {

    private static ScheduledExecutorService se = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
//        schedule();
//        scheduleWithFixedDelay();
        scheduleFixedRate();
    }

    public static void schedule() {
        System.out.println("Start....");
        ScheduledFuture<String> future = se.schedule(() -> "Hello There", 2,TimeUnit.SECONDS);
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            se.shutdown();
        }
        System.out.println("The end!!!");
    }

    public static void scheduleWithFixedDelay() {
        System.out.println("Start....");
        se.scheduleWithFixedDelay(
                () -> System.out.println("Hello There"),
                3,
                1,
                TimeUnit.SECONDS
        );

    }

    public static void scheduleFixedRate() {
        System.out.println("Start....");
        se.scheduleAtFixedRate(
                () -> System.out.println("Hello There"),
                3,
                1,
                TimeUnit.SECONDS
        );
    }
}
