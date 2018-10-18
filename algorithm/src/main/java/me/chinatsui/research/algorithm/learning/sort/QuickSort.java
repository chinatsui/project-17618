package me.chinatsui.research.algorithm.learning.sort;


import java.util.LinkedList;

public class QuickSort extends Sort {

    public static void main(String[] args) {
        new QuickSort().test(10);
    }

    @Override
    void sort(Comparable[] a) {
        Solution1.INSTANCE.sort(a);
    }

    public enum Solution1 {
        INSTANCE;

        public void sort(Comparable[] a) {
            sort(a, 0, a.length - 1);
        }

        private void sort(Comparable[] a, int low, int hi) {

            if (low >= hi)
                return;

            int pivot = hi;

            int sm = low - 1;
            for (int i = low; i <= hi - 1; i++) {
                if (a[i].compareTo(a[pivot]) < 0) {
                    sm++;
                    if (sm != i) {
                        swap(a, sm, i);
                    }
                }
            }
            swap(a, sm + 1, pivot);
            pivot = sm + 1;

            sort(a, low, pivot - 1);
            sort(a, pivot + 1, hi);
        }
    }

    public enum Solution2 {
        INSTANCE;

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
                        if (a[i].compareTo(a[pivot]) < 0) {
                            sm++;
                            if (sm != i) {
                                swap(a, sm, i);
                            }
                        }
                    }
                    swap(a, sm + 1, pivot);
                    pivot = sm + 1;
                    q.offer(lo);
                    q.offer(pivot - 1);
                    q.offer(pivot + 1);
                    q.offer(hi);
                }
            }
        }
    }
}
