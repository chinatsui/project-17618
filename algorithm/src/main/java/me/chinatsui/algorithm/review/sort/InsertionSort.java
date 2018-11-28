package me.chinatsui.algorithm.review.sort;

// o(n^2)/4 ~ o(n^2)/2
public class InsertionSort extends Sort {

    @Override
    void sort(Comparable[] data) {
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j >= 1 && less(data[j], data[j - 1]); j--) {
                swap(data, j - 1, j);
            }
        }
    }
}
