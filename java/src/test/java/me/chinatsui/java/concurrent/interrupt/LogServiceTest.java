package me.chinatsui.java.concurrent.interrupt;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.java.commons.RandomUtils;

public class LogServiceTest {

    @Test
    public void test_log_service_could_be_stopped_as_expected() throws InterruptedException {
        LogService logService = new LogService();
        logService.start();

        ThreadPoolExecutor producers = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        new Thread(() -> {
            while (true) {
                try {
                    producers.submit(() -> {
                        try {
                            logService.log(RandomUtils.getRandomString(10));
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    });
                } catch (RejectedExecutionException e) {
                    break;
                }
            }
        }).start();

        // After LogService runs a while, we stop it for later testing.
        sleep(100);
        logService.stop();

        /* After stop, logger thread would continue handles all message remains,
         * then step into termination state.
         */
        logService.await(1000);
        Assert.assertEquals(0, logService.queue().size());

        // Ideally no producer blocks on putting message.
        producers.shutdown();
        producers.awaitTermination(1000, TimeUnit.MILLISECONDS);
        Assert.assertEquals(0, producers.getActiveCount());
    }
}
