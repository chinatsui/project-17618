package me.chinatsui.research.algorithm.learning.sort;


public class QuickSort extends Sort {

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int hi) {

        if (low >= hi)
            return;

        int split = low;

        for (int i = low + 1; i <= hi; i++) {
            if (less(a[i], a[split])) {
                swap(a, split++, i);
            }
        }

        sort(a, low, split - 1);
        sort(a, split + 1, hi);
    }

    private void swap(Comparable[] a, int s, int t) {

        if (s < 0 || t >= a.length || t < s) {
            throw new IllegalArgumentException();
        }

        Comparable m = a[t];

        for (int i = t; i > s; i--) {
            a[i] = a[i - 1];
        }

        a[s] = m;
    }

}
