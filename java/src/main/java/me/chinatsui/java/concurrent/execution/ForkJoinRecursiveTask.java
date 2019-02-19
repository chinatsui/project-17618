package me.chinatsui.java.concurrent.execution;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

/*
 * Given: 4
 * Output: 4*4 + 3*3 + 2*2 + 1*1
 */
public class ForkJoinRecursiveTask {

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Integer res = pool.invoke(new FactorialSquareSumTask(4));
        System.out.println(res);
    }

    private static class FactorialSquareSumTask extends RecursiveTask<Integer> {

        private static final long serialVersionUID = 1L;
        private Integer num;

        FactorialSquareSumTask(Integer num) {
            this.num = num;
        }

        @Override
        protected Integer compute() {
            if (num < 2) {
                return 1;
            } else {
                FactorialSquareSumTask subTask = new FactorialSquareSumTask(num - 1);
                subTask.fork();
                sleep(200);
                return num * num + subTask.join();
            }
        }
    }
}
