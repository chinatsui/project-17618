package me.chinatsui.algorithm.review.sort;


public class ShellSort extends Sort {

    @Override
    void sort(Comparable[] data) {
        int h = 1;

        while (h <= data.length / 4) {
            h = h * 4;
        }

        while (h >= 1) {
            for (int i = h; i < data.length; i++) {
                for (int j = i; j >= h && less(data[j], data[j - h]); j -= h) {
                    swap(data, j - h, j);
                }
            }
            h = h / 4;
        }
    }

}
