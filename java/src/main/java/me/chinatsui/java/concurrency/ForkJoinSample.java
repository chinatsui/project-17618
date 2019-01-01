package me.chinatsui.java.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

public class ForkJoinSample {

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Integer res = pool.invoke(new FactorialSquareTask(8));
        System.out.println(res);
    }

    private static class FactorialSquareTask extends RecursiveTask<Integer> {

        private Integer num;

        public FactorialSquareTask(Integer num) {
            this.num = num;
        }

        @Override
        protected Integer compute() {
            if (num < 2) {
                return 1;
            } else {
                FactorialSquareTask subTask = new FactorialSquareTask(num - 1);
                subTask.fork();

                /**
                 * Simulate a long time calculation.
                 */
                try {
                    int cost = ThreadLocalRandom.current().nextInt(1000, 3000);
                    Thread.sleep(cost);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                return num * num + subTask.join();
            }
        }
    }
}
