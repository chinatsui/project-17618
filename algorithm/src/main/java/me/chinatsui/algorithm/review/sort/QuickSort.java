package me.chinatsui.algorithm.review.sort;


import me.chinatsui.algorithm.util.DataUtils;

import java.util.Arrays;

public class QuickSort extends Sort {

    public static void main(String[] args) {
        Integer[] arr = DataUtils.getRandomIntegerArray(20);
        System.out.println(Arrays.toString(arr));
        new QuickSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    void sort(Comparable[] data) {
        Solution.INSTANCE.sort(data);
    }

    public enum Solution {
        INSTANCE;

        public void sort(Comparable[] data) {
            if (data == null || data.length < 1) {
                return;
            }

            int lo = 0, hi = data.length - 1;
            partition(data, lo, hi);
        }

        private void partition(Comparable[] data, int lo, int hi) {
            if (lo >= hi) {
                return;
            }

            int sm = lo - 1, pivot = hi;
            for (int i = lo; i < hi; i++) {
                if (data[i].compareTo(data[pivot]) < 0) {
                    swap(data, ++sm, i);
                }
            }

            swap(data, sm + 1, pivot);
            pivot = sm + 1;
            partition(data, lo, pivot - 1);
            partition(data, pivot + 1, hi);
        }
    }
}
