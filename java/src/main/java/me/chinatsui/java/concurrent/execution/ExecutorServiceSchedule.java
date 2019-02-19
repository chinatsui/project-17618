package me.chinatsui.java.concurrent.execution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

public class ExecutorServiceSchedule {

    private ExecutorServiceSchedule() {
    }

    public static void main(String[] args) throws InterruptedException {
        new ExecutorServiceSchedule().scheduleExecutorService();
    }

    /**
     *
     * 1. Whatever how many threads in ScheduleExecutorService pool, the single task is always scheduled one by one.
     * 2. It is possible the task is scheduled in the different thread each time.
     * 3. shutdown() would immediately terminate the ScheduleExecutorService pool.
     *
     */
    private void scheduleExecutorService() {
        int processors = Runtime.getRuntime().availableProcessors();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(processors);
        scheduledExecutorService.scheduleAtFixedRate(new Task("Task1"), 0, 100, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Task("Task2"), 0, 100, TimeUnit.MILLISECONDS);
        sleep(3000);
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

        Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            String msg = String.format(Thread.currentThread().getName() + ": %s executed.", this.name);
            System.out.println(msg);
            sleep(300);
        }
    }
}
