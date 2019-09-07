package me.chinatsui.algorithm.exercise.sort;

public class BubbleSort extends Sort {

    public void sort(int[] nums) {
        if (!isArrayValidForSort(nums)) {
            return;
        }

        int n = nums.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n - j - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }
}
