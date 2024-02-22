package org.example.concurrency;


import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 *  Blocking Queues
 *
 *  -> While ConcurrentLinkedQueue and LinkedBlockingQueue
 *  are both thread-safe Queue implementations, LinkedBlockingQueue adds some
 *  extra methods for blocking i.e. waiting for a certain time period.
 *
 *  method name:
 *      -> E poll(long timeout,TimeUnit unit)
 *          retrieves and removes the head of this queue, waiting up to the specified time
 *          if necessary
 *
 *      -> offer(E e,long timeout,TimeUnit unit)
 *          Inserts the element into the queue, waiting up to the specified time if necessary.
 *

 *
 */

public class BlockingQueues {
    public static void main(String[] args) {
        BlockingQueue<String > queue = new LinkedBlockingQueue<>();
        queue.offer("Red");
        queue.offer("Green");
        queue.offer("Blue");
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue);


        try {
            queue.offer("White",100, TimeUnit.MILLISECONDS);
            queue.poll(200,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(queue);
    }
}
