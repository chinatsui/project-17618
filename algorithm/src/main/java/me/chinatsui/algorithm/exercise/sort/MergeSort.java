package me.chinatsui.algorithm.exercise.sort;

public class MergeSort extends Sort {

    private int[] aux;

    public void sort(int[] nums) {
        if (!isArrayValidForSort(nums)) {
            return;
        }

        int n = nums.length;
        aux = new int[n];

        // The way of recursion is too simple, here gives the way of iteration.
        for (int i = 1; i < n; i *= 2) {
            for (int lo = 0; lo + i - 1 < n; ) {
                int mi = lo + i - 1;
                int hi = mi + i;
                if (hi >= n) {
                    hi = n - 1;
                }
                merge(nums, lo, mi, hi);
                lo = hi + 1;
            }
        }
    }

    private void merge(int[] nums, int lo, int mi, int hi) {
        System.arraycopy(nums, lo, aux, lo, hi - lo + 1);

        int left = lo, right = mi + 1;
        for (int i = lo; i <= hi; i++) {
            if (left > mi) {
                nums[i] = aux[right++];
            } else if (right > hi) {
                nums[i] = aux[left++];
            } else if (aux[left] < aux[right]) {
                nums[i] = aux[left++];
            } else {
                nums[i] = aux[right++];
            }
        }
    }
}
