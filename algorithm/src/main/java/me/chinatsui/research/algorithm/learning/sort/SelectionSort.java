package me.chinatsui.research.algorithm.learning.sort;

import java.util.Arrays;

// o(n^2)
public class SelectionSort extends Sort {

    @Override
    void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

}
