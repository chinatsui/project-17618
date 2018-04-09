package me.chinatsui.research.algorithm.learning.sort;


import java.util.LinkedList;

public class QuickSort2 extends Sort {

    public static void main(String[] args) {
        new QuickSort2().test(100);
    }

    @Override
    public void sort(Comparable[] a) {
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(0);
        q.offer(a.length - 1);

        while (!q.isEmpty()) {
            int lo = q.poll();
            int hi = q.poll();

            if (lo < hi) {
                int pivot = hi;
                int sm = lo - 1;
                for (int i = lo; i <= hi - 1; i++) {
                    if (less(a[i], a[pivot])) {
                        sm++;
                        if (sm != i) {
                            exchange(a, sm, i);
                        }
                    }
                }
                exchange(a, sm + 1, pivot);
                pivot = sm + 1;
                q.offer(lo);
                q.offer(pivot - 1);
                q.offer(pivot + 1);
                q.offer(hi);
            }
        }
    }

}
