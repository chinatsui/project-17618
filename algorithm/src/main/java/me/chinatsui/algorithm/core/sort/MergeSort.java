package me.chinatsui.algorithm.core.sort;

import java.util.Arrays;

public class MergeSort extends AbstractSort {

    public void sortWithIteration(int[] nums) {
        if (isEmpty(nums)) {
            return;
        }

        for (int i = 1; i < nums.length; i *= 2) {
            for (int lo = 0; lo + i - 1 < nums.length; lo += 2 * i) {
                int mid = lo + i - 1;
                int hi = mid + i;
                if (hi >= nums.length) {
                    hi = nums.length - 1;
                }
                merge(nums, lo, mid, hi);
            }
        }
    }

    public void sortWithRecursion(int[] nums) {
        if (isEmpty(nums)) {
            return;
        }

        int lo = 0, hi = nums.length - 1;
        sortWithRecursion(nums, lo, hi);
    }

    private void sortWithRecursion(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sortWithRecursion(nums, lo, mid);
        sortWithRecursion(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int[] aux = Arrays.copyOf(nums, nums.length);
        int left = lo, right = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (right > hi) {
                nums[i] = aux[left++];
            } else if (left > mid) {
                nums[i] = aux[right++];
            } else if (aux[left] < aux[right]) {
                nums[i] = aux[left++];
            } else {
                nums[i] = aux[right++];
            }
        }
    }
}
