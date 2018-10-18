package me.chinatsui.research.algorithm.learning.sort;

import me.chinatsui.research.algorithm.utils.DataUtils;

import java.util.Arrays;

public class MergeSort extends Sort {

    public static void main(String[] args) {
        Integer[] a = DataUtils.getRandomIntegerArray(20);
        System.out.println(Arrays.toString(a));
        System.out.println("----");
        new MergeSort().sort(a);
        System.out.println("----");
        System.out.println(Arrays.toString(a));
    }

    @Override
    void sort(Comparable[] a) {
        Solution1.INSTANCE.sort(a);
    }

    public enum Solution1 {
        INSTANCE;

        private Comparable[] aux;

        public void sort(Comparable[] a) {
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1);
        }

        private void sort(Comparable[] a, int lo, int hi) {
            if (lo >= hi) {
                return;
            }

            int mid = (lo + hi) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);

            merge(a, lo, mid, hi);
        }

        private void merge(Comparable[] a, int lo, int mid, int hi) {
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }

            for (int k = lo, i = lo, j = mid + 1; k <= hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++]; // Left is over
                } else if (j > hi) {
                    a[k] = aux[i++]; // Right is over
                } else if (aux[i].compareTo(aux[j]) < 0) {
                    a[k] = aux[i++];
                } else {
                    a[k] = aux[j++];
                }
            }
        }
    }

    private enum Solution2 {
        INSTANCE;

        Comparable[] aux;

        void sort(Comparable[] a) {
            int n = a.length;
            aux = new Comparable[n];

            for (int i = 1; i < n; i *= 2) {
                for (int lo = 0; lo + i - 1 < n; lo += 2 * i) {
                    int mid = lo + i - 1;
                    int hi = mid + i;
                    if (hi > n - 1) {
                        hi = n - 1;
                    }
                    merge(a, lo, mid, hi);
                }
            }
        }

        private void merge(Comparable[] nums, int lo, int mi, int hi) {
            for (int i = lo; i <= hi; i++) {
                aux[i] = nums[i];
            }

            int left = lo;
            int right = mi + 1;
            for (int i = lo; i <= hi; i++) {
                if (left > mi) {
                    nums[i] = aux[right++];
                } else if (right > hi) {
                    nums[i] = aux[left++];
                } else if (aux[left].compareTo(aux[right]) < 0) {
                    nums[i] = aux[left++];
                } else {
                    nums[i] = aux[right++];
                }
            }
        }
    }
}
