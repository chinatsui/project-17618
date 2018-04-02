package me.chinatsui.exercise.leetcode.mar;

import java.util.Arrays;

public enum RotateArray {

    INSTANCE;

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        INSTANCE.rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        if (nums != null) {
            int n = nums.length;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }
    }

    private void reverse(int[] nums, int src, int dst) {
        while (src < dst) {
            int tmp = nums[dst];
            nums[dst] = nums[src];
            nums[src] = tmp;
            src++;
            dst--;
        }
    }

}
