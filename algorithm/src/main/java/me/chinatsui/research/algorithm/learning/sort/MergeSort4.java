package me.chinatsui.research.algorithm.learning.sort;

public class MergeSort4 extends Sort {

    Comparable[] aux;

    public static void main(String[] args) {
        new MergeSort4().test(100);
    }

    @Override
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
            } else if (less(aux[left], aux[right])) {
                nums[i] = aux[left++];
            } else {
                nums[i] = aux[right++];
            }
        }
    }

}
