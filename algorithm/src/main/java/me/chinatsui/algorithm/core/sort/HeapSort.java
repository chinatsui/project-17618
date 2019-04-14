package me.chinatsui.algorithm.core.sort;

public class HeapSort extends AbstractSort {

    public void sort(int[] nums) {
        if (isEmpty(nums)) {
            return;
        }

        heapify(nums);
        int tail = nums.length - 1;
        while (tail > 0) {
            swap(nums, 0, tail);
            sink(nums, 0, tail - 1);
            tail--;
        }
    }

    private void heapify(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            sink(nums, i, n - 1);
        }
    }

    private void sink(int[] nums, int i, int bound) {
        int L = (i + 1) * 2 - 1;
        int R = (i + 1) * 2;

        if (R <= bound) {
            if (nums[L] <= nums[R] && nums[i] < nums[R]) {
                swap(nums, i, R);
                sink(nums, R, bound);
            } else if (nums[R] <= nums[L] && nums[i] < nums[L]) {
                swap(nums, i, L);
                sink(nums, L, bound);
            }
        } else if (L <= bound) {
            if (nums[i] < nums[L]) {
                swap(nums, i, L);
            }
        }
    }
}
