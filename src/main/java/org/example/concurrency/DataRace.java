package org.example.concurrency;

public class DataRace {
    private static int count = 0;

    public static void addCount() {
        System.out.println("Before: " + count + " - Thread id: " + Thread.currentThread().getName());
        count++;
        System.out.println("After: " + count + " - Thread id: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(DataRace::addCount).start();
        }
    }
}
