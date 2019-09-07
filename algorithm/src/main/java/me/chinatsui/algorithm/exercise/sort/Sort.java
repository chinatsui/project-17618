package me.chinatsui.algorithm.exercise.sort;

public abstract class Sort {

    abstract void sort(int[] nums);

    protected boolean isArrayValidForSort(int[] nums) {
        return nums != null && nums.length > 1;
    }

    protected void swap(int[] nums, int src, int dst) {
        int tmp = nums[src];
        nums[src] = nums[dst];
        nums[dst] = tmp;
    }
}
