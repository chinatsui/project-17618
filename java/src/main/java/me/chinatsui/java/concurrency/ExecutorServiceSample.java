package me.chinatsui.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceSample {

    private final static ExecutorServiceSample instance = new ExecutorServiceSample();

    private ExecutorServiceSample() {
    }

    public static void main(String[] args) throws InterruptedException {
        instance.practiseScheduleExecutorService();
    }

    public void practiseStopExecutorService() {
        int processors = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(processors);

        executorService.submit(new Task());
        executorService.submit(new Task());

        shutdownExecutorService(executorService);
    }

    /**
     *
     * 1. Whatever how many threads in ScheduleExecutorService pool, the single task is always scheduled one by one.
     * 2. It is possible the task is scheduled in the different thread each time.
     * 3. shutdown() would immediately terminate the ScheduleExecutorService pool.
     *
     */
    public void practiseScheduleExecutorService() throws InterruptedException {
        int processors = Runtime.getRuntime().availableProcessors();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(processors);
        scheduledExecutorService.scheduleAtFixedRate(new Task(1000), 0, 100, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new Task(20000), 0, 100, TimeUnit.MILLISECONDS);
        Thread.sleep(5000);
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
        private static int count = 0;
        private String name;
        private Long time;

        public Task() {
            this(1000L);
        }

        public Task(long time) {
            this.name = "Task" + count;
            this.time = time;
            count++;
        }

        @Override
        public void run() {
            try {
                String msg = String.format(Thread.currentThread().getName() + ": %s executed.", this.name);
                System.out.println(msg);
                Thread.sleep(this.time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
