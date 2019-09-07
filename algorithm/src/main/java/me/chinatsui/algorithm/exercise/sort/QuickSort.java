package me.chinatsui.algorithm.exercise.sort;

public class QuickSort extends Sort {

    public void sort(int[] nums) {
        if (!isArrayValidForSort(nums)) {
            return;
        }

        partition(nums, 0, nums.length - 1);
    }

    /*
     * This implementation is using the way of recursion,
     * actually the way of iteration is also simple by using queue.
     */
    private void partition(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int sm = lo - 1, p = hi;
        for (int i = lo; i < hi; i++) {
            if (nums[i] < nums[p]) {
                swap(nums, ++sm, i);
            }
        }

        swap(nums, ++sm, p);
        p = sm;
        partition(nums, lo, p - 1);
        partition(nums, p + 1, hi);
    }
}
