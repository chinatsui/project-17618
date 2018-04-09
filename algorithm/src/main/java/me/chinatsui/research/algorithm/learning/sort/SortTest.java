package me.chinatsui.research.algorithm.learning.sort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SortTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 4);

        executor.submit(new SortTestTask(new MergeSort()));
        executor.submit(new SortTestTask(new ShellSort()));
        executor.submit(new SortTestTask(new SystemArraySort()));
        executor.submit(new SortTestTask(new InsertionSort()));
        executor.submit(new SortTestTask(new SelectionSort()));
        executor.submit(new SortTestTask(new QuickSort()));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.HOURS);
    }

    private static class SortTestTask implements Runnable {

        private final Sort sort;

        public SortTestTask(Sort sort) {
            this.sort = sort;
        }

        @Override
        public void run() {
            sort.test(100*100*100);
        }

    }

}
