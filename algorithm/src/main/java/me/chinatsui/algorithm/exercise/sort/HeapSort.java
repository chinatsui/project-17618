package me.chinatsui.algorithm.exercise.sort;

public class HeapSort extends Sort {

    public void sort(int[] nums) {
        if (!isArrayValidForSort(nums)) {
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
        for (int i = n / 2; i >= 0; i--) {
            sink(nums, i, n - 1);
        }
    }

    private void sink(int[] nums, int i, int bound) {
        int j = (i + 1) * 2 - 1, k = j + 1, n = nums.length;

        if (j == bound) {
            if (nums[i] < nums[j]) {
                swap(nums, i, j);
            }
        } else if (k <= bound) {
            int lg = nums[j] > nums[k] ? j : k;
            if (nums[i] < nums[lg]) {
                swap(nums, i, lg);
                sink(nums, lg, bound);
            }
        }
    }
}
