package me.chinatsui.algorithm.exercise.arr;

/**
 * Created by chinatsui on 09/01/2018.
 */
public class MaximumSubArray {

    /*
     * [-2,1,-3,4,-1,2,1,-5,4] -> 6
     */

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Solution.INSTANCE.maxSubArray(nums));
    }

    public enum Solution {
        INSTANCE;

        public int maxSubArray(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int tmp = nums[0];
            int res = nums[0];

            for (int i = 1; i < nums.length; i++) {
                tmp = Math.max(tmp + nums[i], nums[i]);
                res = Math.max(res, tmp);
            }

            return res;
        }
    }
}
