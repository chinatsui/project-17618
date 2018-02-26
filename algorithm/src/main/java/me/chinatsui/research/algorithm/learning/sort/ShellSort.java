package me.chinatsui.research.algorithm.learning.sort;


public class ShellSort extends Sort {

    @Override
    void sort(Comparable[] a) {
        int h = 1;

        while (h <= a.length / 4) {
            h = h * 4;
        }

        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j - h, j);
                }
            }
            h = h / 4;
        }
    }

}
