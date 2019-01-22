package me.chinatsui.java.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureSample {

    private static final CompletableFutureSample instance = new CompletableFutureSample();

    private CompletableFutureSample() {
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        instance.combineAsyncComputations();
    }

    public void runAsSimpleFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture();

        ExecutorService pool = Executors.newCachedThreadPool();
        try {
            pool.submit(() -> {
                Thread.sleep(2000);
                future.complete("Finished.");
//                future.cancel(false);
                return null;
            });

            future.get();
        } finally {
            pool.shutdownNow();
        }
    }

    public void executeAsyncComputation() {
        // Runnable
        CompletableFuture.runAsync(() -> {
            // A long run task set here.
        });

        // Supplier, similar to Callable
        CompletableFuture.supplyAsync(() -> "");
    }

    public void chainAsyncComputations() throws ExecutionException, InterruptedException {
        CompletableFuture supply = CompletableFuture.supplyAsync(() -> {
            System.out.println("A supplyAsync Thread: " + Thread.currentThread().getName());
            return "Hello";
        });

        // Chain One, supply -> apply -> accept
        CompletableFuture apply = supply.thenApplyAsync(s -> {
                    System.out.println("Chain one, a thenApplyAsync thread: " + Thread.currentThread().getName());
                    return s + " World";
                }
        );

        CompletableFuture accept = apply.thenAcceptAsync(s -> {
            System.out.println("Chain one, a thenAcceptAsync thread: " + Thread.currentThread().getName());
            System.out.println(s);
        });
        accept.get();

        System.out.println();
        // Chain Two, supply -> run
        CompletableFuture run = supply.thenRunAsync(() -> {
            System.out.println("Chain two, a thenRunAsync thread: " + Thread.currentThread().getName());
        });
        run.get();
    }

    public void combineAsyncComputations() throws ExecutionException, InterruptedException {
        CompletableFuture<String> supply = CompletableFuture.supplyAsync(() -> {
            System.out.println("A supplyAsync thread: " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> anotherSupply = CompletableFuture.supplyAsync(() -> {
            System.out.println("Another supplyAsync thread: " + Thread.currentThread().getName());
            return " World";
        });

        CompletableFuture<String> combine = supply.thenCombineAsync(anotherSupply, (s1, s2) -> {
            System.out.println("A combine thread: " + Thread.currentThread().getName());
            return s1 + s2;
        });

        System.out.println(combine.get());
    }
}
