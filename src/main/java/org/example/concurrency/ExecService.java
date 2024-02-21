package org.example.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 *
 *  -> The ExecutorService is an interface that provides
 *     services for the creation and management of threads
 *
 *  -> The Executors utility class provides static methods that
 *      return ExecutorService implementation
 *
 *   -> A "thread pool" is a set of reusable worker threads available
 *      to execute tasks
 *
 *  Types of ExecutorService:
 *      -> Single thread pool executor:
 *          a single thread is used; and tasks are processed sequentially
 *      -> Cached thread pool executor:
 *          creates a new threads as needed and reuses threads that have become free.
 *      -> Fixed thread pool executor:
 *          creates a fixed number of threads which is specified at the start
 *
 *
 *  Submitting tasks to an ExecutorService
 *  -> A Callable<V> is very similar to a Runnable except that a Callable can
 *      return a result and throw a checked exception
 *
 *  Future<V> interface
 *  -> A Future<V> is used to obtain the results from a Callable's call() method
 *  -> A Future<V> object represents the result of an asynchronous computation. Methods
 *      are provided to check if the computation is complete( isDone() and retrieve the
 *      result of the computation get() )
 *  -> The result can only be retrieved using the method V get() when the computation has completed
 *      , blocking if necessary until it is ready.
 *
 * So get() method is synchronous as we see.
 */

public class ExecService {

    public static void main(String[] args) {

        // Cached Thread pool
        ExecutorService cached = Executors.newCachedThreadPool();

        // Fixed Thread pool
        int cpuCount = Runtime.getRuntime().availableProcessors();
        ExecutorService fixed = Executors.newFixedThreadPool(cpuCount);

        // Single Thread executor
        ExecutorService single = Executors.newSingleThreadExecutor();

    }
}
