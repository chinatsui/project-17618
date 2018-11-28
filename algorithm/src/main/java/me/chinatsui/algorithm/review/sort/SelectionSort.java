package me.chinatsui.algorithm.review.sort;

// o(n^2)
public class SelectionSort extends Sort {

    @Override
    void sort(Comparable[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (less(data[j], data[min])) {
                    min = j;
                }
            }
            swap(data, i, min);
        }
    }

}
