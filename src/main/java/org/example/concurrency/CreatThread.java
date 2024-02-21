package org.example.concurrency;

/**
 *
 *  -> A process consists of one or more threads
 *  -> A thread is the smallest unit of execution. It executes a task
 *  -> The order of thread execution is non-deterministic
 *
 *
 *  3 ways to create a thread:
 *      -> extend Thread
 *      -> implement Runnable
 *      -> implement Callable (requires ExecutorService)
 *
 *
 *
 *
 *
 */

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run(): " + getName());
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("run(): " + Thread.currentThread().getName());
    }
}

public class CreatThread {
    public static void main(String[] args) {
        // The order of output here is non-deterministic (try to run again and again)
        new MyThread().start();
        System.out.println("main(): " + Thread.currentThread().getName());

        new Thread(new MyRunnable()).start();
        System.out.println("main(): " + Thread.currentThread().getName());

        // Using Lambda as a runnable
        Thread t = new Thread(() -> System.out.println("run(): " + Thread.currentThread().getName()));
        t.start();
    }
}
