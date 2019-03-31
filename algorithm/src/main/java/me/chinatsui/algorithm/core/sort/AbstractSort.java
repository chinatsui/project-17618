package me.chinatsui.algorithm.core.sort;

public abstract class AbstractSort {

    protected boolean isEmpty(int[] nums) {
        return nums == null || nums.length < 1;
    }

    protected void swap(int[] nums, int src, int dst) {
        int tmp = nums[src];
        nums[src] = nums[dst];
        nums[dst] = tmp;
    }
}
