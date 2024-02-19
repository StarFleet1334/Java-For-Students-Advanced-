package org.example.collectionsAndGenerics.collections;

import org.example.streams.exam.solution.Book;

import java.util.*;

/***
 *
 * Queue - a collection that specifies the order in which elements are to be processed.
 *
 * Note:
 *  -> LinkedList implements Queue
 *
 *
 *  PriorityQueue
 *      -> orders the elements relative to each other such that
 *          "priority-in, priority-out"
 *      -> the elements are either ordered by natural order or by custom comparator
 *      -> elements that are sorted first will be accessed first
 *
 *  Dequeue
 *      -> access from both ends permitted
 *      -> can be used as both FIFO(queue) and LIFO (Stack)
 *
 *  ArrayDequeue
 *      -> expandable array implementation of the Dequeue interface
 *
 *
 *
 */


public class QueueAndDequeueExercise {

    public static void main(String[] args) {

    }

    public static void linkedListQueue() {
        // FIFO queue -> First in and First out
        // add() inserts into queue but will throw exception if no space exists that happens when
        // capacity is restricted. offer() inserts into queue and returns false in the same scenario

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.offer(2);
        queue.add(3);
        queue.offer(4);

        // element() retrieves but does not remove head of the queue, but in case if queue is empty
        // it throws exception and peek() same thing but in same scenario it returns null if queue
        // is empty
        System.out.println("Head of the queue: " + queue.element());
        System.out.println("Head of the queue: " + queue.peek());
        System.out.println(queue);

        // remove() retrieves and removes head of the queue and throws exception if queue is empty
        // poll() retrieves and removes the head of this queue and returns null if it is empty
        System.out.println("Removed head: " + queue.remove() + ", remaining queue: " + queue);
        System.out.println("Removed head: " + queue.poll() + ", remaining queue: " + queue);
    }

    public static void arrayDequeue() {
        // Resizeable array implementation of the dequeue interface (no capacity restrictions)
        Deque<Integer> numbers = new ArrayDeque<>();
        numbers.add(1); // [1]
        numbers.addFirst(2); // [2,1]
        numbers.offerFirst(3); // [3,2,1]
        System.out.println("Head : " + numbers.getFirst() + ", Head: " + numbers.peek());

        numbers.addLast(4); // [3,2,1,4]
        numbers.offerFirst(5); // [3,2,1,4,5]

        numbers.removeFirst(); // [2,1,4,5]
        numbers.pollFirst(); // [1,4,5]
        numbers.removeLast(); // [1,4]
        numbers.pollLast(); // [1]
        System.out.println(numbers);
    }

    public static void priorityQueueNaturalOrdering() {
        Queue<String> names = new PriorityQueue<>();
        names.add("V");
        names.add("P");
        names.add("A");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(names.poll() + " ");
        }

        Queue<Integer> numbers = new PriorityQueue<>();
        numbers.add(11);
        numbers.add(5);
        numbers.add(2);
        Iterator<Integer> iterator1 = numbers.iterator();
        while (iterator1.hasNext()) {
            System.out.println(numbers.poll() + " ");
        }
    }

    public static void priorityQueueDifferentOrdering() {
        // Ordering specified by a comparator at construction time
        // Ordering by the title of the book
        Comparator<Book> comparator = Comparator.comparing(book -> book.getTitle());
        Queue<Book> booksByTitle = new PriorityQueue<>(comparator);
        booksByTitle.add(new Book("Java",55.0));
        booksByTitle.add(new Book("Python",23.0));
        booksByTitle.add(new Book("C++",99.0));

        System.out.println("Ordering by title: ");
        Iterator<Book> iterator = booksByTitle.iterator();
        while (iterator.hasNext()) {
            Book book = booksByTitle.poll();
            System.out.println(book);
        }
    }
}
