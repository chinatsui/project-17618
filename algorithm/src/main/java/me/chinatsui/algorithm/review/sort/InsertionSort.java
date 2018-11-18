package me.chinatsui.algorithm.review.sort;

// o(n^2)/4 ~ o(n^2)/2
public class InsertionSort extends Sort {

    @Override
    void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >= 1 && less(a[j], a[j - 1]); j--) {
                swap(a, j - 1, j);
            }
        }
    }

}
