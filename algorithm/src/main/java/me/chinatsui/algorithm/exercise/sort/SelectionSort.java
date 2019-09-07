package me.chinatsui.algorithm.exercise.sort;

public class SelectionSort extends Sort {

    @Override
    void sort(int[] nums) {
        isArrayValidForSort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }
}
