package org.example.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SubmittingTaskCollections {
    // Here we are using Executor Service single Thread executor so the tasks are done
    // sequentially
//    private static ExecutorService executorService = Executors.newSingleThreadExecutor();


    private static ExecutorService executorService = Executors.newFixedThreadPool(4);

    private static List<Callable<String >> callableList = new ArrayList<>();


    public static void main(String[] args) {
        callableList.add(() -> "A");
        callableList.add(() -> "B");
        callableList.add(() -> "C");
        callableList.add(() -> "D");
        callableList.add(() -> "E");

//        invokeAny();
        invokeAll();
    }

    public static void invokeAny() {

        /**
         * Executes the given tasks, returning the result of one that has completed
         * successfully (i.e., without throwing an exception), if any do. Upon normal
         * or exceptional return, tasks that have not completed are cancelled.
         * The results of this method are undefined if the given collection is
         * modified while this operation is in progress.
         *
         */

        try {
            String result = executorService.invokeAny(callableList);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
        System.out.println("The end!!");
    }

    public static void invokeAll() {

        /**
         *
         * Executes the given tasks, returning a list of Futures holding their
             * status and results when all complete. Future.isDone is true for each
             * element of the returned list. Note that a completed task could have
             * terminated either normally or by throwing an exception. The results
             * of this method are undefined if the given collection is modified while
             * this operation is in progress.
         * Params tasks – the collection of tasks
         * Returns:
             * a list of Futures representing the tasks, in the same sequential
             * order as produced by the iterator for the given task list, each of
             * which has completed
         *
         *
         *
         *
         */
        try {
            List<Future<String>> result = executorService.invokeAll(callableList);
            for (Future<String> x : result) {
                System.out.println(x.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
        System.out.println("The end!!");
    }

}
