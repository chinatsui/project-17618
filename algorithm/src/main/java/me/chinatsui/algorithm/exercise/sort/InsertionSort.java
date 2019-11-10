package me.chinatsui.algorithm.exercise.sort;

public class InsertionSort extends Sort {

    @Override
    public void sort(int[] nums) {
        if (!isArrayValidForSort(nums)) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    System.arraycopy(nums, j, nums, j + 1, i - j);
                    nums[j] = tmp;
                }
            }
        }
    }
}
