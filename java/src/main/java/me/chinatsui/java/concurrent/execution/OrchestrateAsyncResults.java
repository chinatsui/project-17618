package me.chinatsui.java.concurrent.execution;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

/**
 * As class name describes, multiple async results could be orchestrated in a way.
 */
public class OrchestrateAsyncResults {

    private OrchestrateAsyncResults() {
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OrchestrateAsyncResults instance = new OrchestrateAsyncResults();
        instance.chainAsyncComputations();
        instance.combineAsyncComputations();
    }

    private void chainAsyncComputations() throws ExecutionException, InterruptedException {
        CompletableFuture<String> supply = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ": supplyAsync");
            sleep(200);
            return "Hello";
        });

        // Chain Two, supply -> run
        CompletableFuture<Void> run = supply.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ": thenRunAsync");
            sleep(500);
        });

        // Chain One, supply -> apply -> accept
        CompletableFuture<String> apply = supply.thenApplyAsync(s -> {
                    System.out.println(Thread.currentThread().getName() + ": thenApplyAsync");
                    sleep(300);
                    return s + " World";
                }
        );
        CompletableFuture<Void> accept = apply.thenAcceptAsync(s -> {
            System.out.println(Thread.currentThread().getName() + ": thenAcceptAsync");
            sleep(400);
            System.out.println(Thread.currentThread().getName() + ": " + s);
        });

        accept.get();
        run.get();
    }

    private void combineAsyncComputations() throws ExecutionException, InterruptedException {
        CompletableFuture<String> supply1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ": supplyAsync1");
            sleep(400);
            return "Hello";
        });

        CompletableFuture<String> supply2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + ": supplyAsync2");
            sleep(200);
            return " World";
        });

        CompletableFuture<String> combine = supply1.thenCombineAsync(supply2, (s1, s2) -> {
            sleep(200);
            System.out.println(Thread.currentThread().getName() + ": supplyAsync1 + supplyAsync2");
            return s1 + s2;
        });

        System.out.println("Result: " + combine.get());
    }
}
