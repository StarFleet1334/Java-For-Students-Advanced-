package org.example.concurrency;


/**
 *
 * Atomic classes do not give us the ability to guard/protect a block of code.
 * In effect, we want to create a manually exclusive piece of code, such that
 * only one thread at atime can execute the code block.
 *
 * In operating systems, these mutually exclusive code blocks are known as critical sections
 * and data structures known as monitors enables their implementation.
 *
 * Every object in Java,has a built-in lock/monitor that automatically kicks in when
 * used with synchronized code blocks
 *
 * Synchronized keyword:
 *  -> A thread wishing to enter a synchronized code block will automatically try to
 *  acquire the lock. if the lock is free it will get the lock.
 *  -> Any other thread now arriving will have to wait until the first thread is finished in
 *  the critical section
 *  -> When the first thread exits the critical section, the lock is released automatically.
 *  Now one of the waiting threads will be allowed to obtain the lock and enter the critical section.
 *
 *  -> Note that threads must bue using the same object. if the threads are using different
 *  objects then they are using different locks and we will encounter data races.
 *
 *  We can use the synchronized keyword on the methods as well as code blocks
 *
 *
 * -> public synchronized static void addToCounter()
 *
 * -> public static void addToCounter() {
 *     synchronized(FIxRaceWithSynchronized.class) {}
 *      // Here this is same as above except we explicitly do this
 *      // In above it was doing it implicitly on background
 * }
 *
 * -> synchronized(lock)
 *
 *
 */

public class FIxRaceWithSynchronized {
    private static Object lock = new DataRace();
    private static int count = 0;

//    public static void addToCounter() {
//        synchronized (FIxRaceWithSynchronized.class) {
//            System.out.println("Before count: " + count + " - Thread: " + Thread.currentThread().getName());
//            count++;
//            System.out.println("After count: " + count + " - Thread: " + Thread.currentThread().getName());
//
//        }
//    }

//    public synchronized static void addToCounter() {
//        System.out.println("Before count: " + count + " - Thread: " + Thread.currentThread().getName());
//        count++;
//        System.out.println("After count: " + count + " - Thread: " + Thread.currentThread().getName());
//
//    }

        public void addToCounter() {
            synchronized (this) {
                System.out.println("Before count: " + count + " - Thread: " + Thread.currentThread().getName());
                count++;
                System.out.println("After count: " + count + " - Thread: " + Thread.currentThread().getName());
            }
    }

    public static void main(String[] args) {
            FIxRaceWithSynchronized instance = new FIxRaceWithSynchronized();
        for (int i = 0; i < 5; i++) {
            new Thread(instance::addToCounter).start();
        }
    }
}
