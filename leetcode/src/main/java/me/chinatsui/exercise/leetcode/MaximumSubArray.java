package me.chinatsui.exercise.leetcode;

/**
 * Created by chinatsui on 09/01/2018.
 */
public class MaximumSubArray {

    /*
     * [-2,1,-3,4,-1,2,1,-5,4] -> 6
     */

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubArray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int local = nums[0];
        int global = nums[0];

        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(global, local);
        }

        return global;
    }

}
