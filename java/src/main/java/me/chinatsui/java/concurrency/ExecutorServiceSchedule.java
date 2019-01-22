package me.chinatsui.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import me.chinatsui.java.commons.ThreadUtils;

public class ExecutorServiceSchedule {

    private final static ExecutorServiceSchedule instance = new ExecutorServiceSchedule();

    private ExecutorServiceSchedule() {
    }

    public static void main(String[] args) throws InterruptedException {
        instance.scheduleExecutorService();
    }

    /**
     *
     * 1. Whatever how many threads in ScheduleExecutorService pool, the single task is always scheduled one by one.
     * 2. It is possible the task is scheduled in the different thread each time.
     * 3. shutdown() would immediately terminate the ScheduleExecutorService pool.
     *
     */
    public void scheduleExecutorService() throws InterruptedException {
        int processors = Runtime.getRuntime().availableProcessors();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(processors);
        scheduledExecutorService.scheduleAtFixedRate(new Task("Task1"), 0, 100, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Task("Task2"), 0, 100, TimeUnit.MILLISECONDS);
        Thread.sleep(3000);
        shutdownExecutorService(scheduledExecutorService);
    }

    private void shutdownExecutorService(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(500, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    private static class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            String msg = String.format(Thread.currentThread().getName() + ": %s executed.", this.name);
            System.out.println(msg);
            ThreadUtils.sleep(300);
        }
    }
}
