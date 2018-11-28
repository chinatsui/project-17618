package me.chinatsui.algorithm.review.sort;

import java.util.Arrays;

public class HeapSort extends Sort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 4, 5, 6, 7, 8, 23, 23, 11, 22, 124, 32, 2346};
        Integer[] data = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        new HeapSort().sort(data);
        System.out.println(Arrays.toString(data));
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

            heapify(data);

            int i = data.length - 1;
            while (i > 0) {
                swap(data, 0, i);
                sink(data, 0, i - 1);
                i--;
            }
        }

        private void heapify(Comparable[] data) {
            int n = data.length;
            int m = n / 2;
            while (m >= 0) {
                sink(data, m, n - 1);
                m--;
            }
        }

        private void sink(Comparable[] data, int i, int bound) {
            int left = (i + 1) * 2 - 1;
            int right = (i + 1) * 2;

            if (bound < left) {
                return;
            } else if (bound < right) {
                if (data[left].compareTo(data[i]) > 0) {
                    swap(data, i, left);
                    sink(data, left, bound);
                }
            } else {
                if (data[left].compareTo(data[right]) > 0 && data[left].compareTo(data[i]) > 0) {
                    swap(data, i, left);
                    sink(data, left, bound);
                } else if (data[left].compareTo(data[right]) <= 0 && data[right].compareTo(data[i]) > 0) {
                    swap(data, i, right);
                    sink(data, right, bound);
                }
            }
        }
    }
}
