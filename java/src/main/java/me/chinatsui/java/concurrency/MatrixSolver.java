package me.chinatsui.java.concurrency;

import me.chinatsui.java.commons.RandomUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

/**
 * Use CyclicBarrier to hold all threads until each of them finished their own calculation.
 * Once done, collect each thread's result into final calculation.
 */
public class MatrixSolver {

    final int N;
    final int[][] data;
    final CyclicBarrier barrier;

    public static void main(String[] args) {
        int[][] data = {
                {1, 2, 3, 4, 0},
                {5, 6, 7, 8, 0},
                {9, 10, 11, 12, 0}
        };
        MatrixSolver solver = new MatrixSolver(data);
        solver.solve();
    }

    public MatrixSolver(int[][] data) {
        this.N = data.length;
        this.data = data;
        this.barrier = new CyclicBarrier(N, () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ": All matrix rows are calculated, now collect their results...");
            int bound = data[0].length - 1;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += data[i][bound];
            }
            System.out.println(threadName + ": Finished collection, total result: " + sum);
        });
    }

    public void solve() {
        for (int i = 0; i < this.N; i++) {
            final int row = i;
            new Thread(() -> {
                String threadName = Thread.currentThread().getName();
                int sum = 0;
                int n = data[row].length;
                for (int j = 0; j < n - 1; j++) {
                    sum += data[row][j];
                }
                data[row][n - 1] = sum;
                sleep(RandomUtils.getRandomInt(500, 800));
                System.out.println(threadName + ": Finished calculation for row: " + row + ", result: " + sum);
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
