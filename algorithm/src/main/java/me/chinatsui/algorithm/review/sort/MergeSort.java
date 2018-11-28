package me.chinatsui.algorithm.review.sort;

import me.chinatsui.algorithm.util.DataUtils;

import java.util.Arrays;

public class MergeSort extends Sort {

    public static void main(String[] args) {
        Integer[] a = DataUtils.getRandomIntegerArray(20);
        System.out.println(Arrays.toString(a));
        new MergeSort().sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Override
    void sort(Comparable[] data) {
        Solution2.INSTANCE.sort(data);
    }

    public enum Solution1 {
        INSTANCE;

        public void sort(Comparable[] data) {
            if (data == null || data.length < 1) {
                return;
            }

            int lo = 0, hi = data.length - 1;
            mergeSort(data, lo, hi);
        }

        private void mergeSort(Comparable[] data, int lo, int hi) {
            if (lo >= hi) {
                return;
            }

            int mid = (lo + hi) / 2;
            mergeSort(data, lo, mid);
            mergeSort(data, mid + 1, hi);
            merge(data, lo, mid, hi);
        }

        private void merge(Comparable[] data, int lo, int mid, int hi) {
            Comparable[] aux = Arrays.stream(data).toArray(Comparable[]::new);

            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    data[k] = aux[j++];
                } else if (j > hi) {
                    data[k] = aux[i++];
                } else if (aux[i].compareTo(aux[j]) < 0) {
                    data[k] = aux[i++];
                } else {
                    data[k] = aux[j++];
                }
            }
        }
    }

    public enum Solution2 {
        INSTANCE;

        public void sort(Comparable[] data) {
            if (data == null || data.length < 1) {
                return;
            }

            int i = 1, n = data.length;
            while (i <= n) {
                int lo = 0;
                while (lo + i - 1 < n) {
                    int mid = lo + i - 1;
                    int hi = mid + i;
                    if (hi > n - 1) {
                        hi = n - 1;
                    }
                    merge(data, lo, mid, hi);
                    lo = hi + 1;
                }
                i *= 2;
            }
        }

        private void merge(Comparable[] data, int lo, int mid, int hi) {
            Comparable[] aux = Arrays.stream(data).toArray(Comparable[]::new);

            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    data[k] = aux[j++];
                } else if (j > hi) {
                    data[k] = aux[i++];
                } else if (aux[i].compareTo(aux[j]) < 0) {
                    data[k] = aux[i++];
                } else {
                    data[k] = aux[j++];
                }
            }
        }
    }
}
