package me.chinatsui.java.concurrent.sync;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CountDownLatch;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

/**
 * Make use of CountDownLatch to time multi-tasking.
 */
public class TimeTasks {

    private static final TimeTasks INSTANCE = new TimeTasks();

    private static final int N_THREADS = 10;
    private final CountDownLatch BEGIN_GATE = new CountDownLatch(1);
    private final CountDownLatch END_GATE = new CountDownLatch(N_THREADS);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Trying to start 10 threads to run tasks");
        long time = INSTANCE.timeTasks();
        System.out.println(String.format("All finished, cost time: %sms", time));
    }

    private long timeTasks() throws InterruptedException {
        for (int i = 0; i < N_THREADS; i++) {
            new Thread(() -> {
                try {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(String.format("%s is ready", threadName));
                    BEGIN_GATE.await();
                    sleep(200);
                    System.out.println(String.format("%s finished work", threadName));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    END_GATE.countDown();
                }
            }).start();
        }

        sleep(300);
        Instant start = Instant.now();
        BEGIN_GATE.countDown();
        END_GATE.await();
        Instant end = Instant.now();
        return start.until(end, ChronoUnit.MILLIS);
    }
}
