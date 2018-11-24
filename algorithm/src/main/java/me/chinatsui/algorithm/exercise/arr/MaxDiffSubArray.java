package me.chinatsui.algorithm.exercise.arr;

public class MaxDiffSubArray {

    public static void main(String[] args) {
        int[] nums = {2, -1, -2, 1, -4, 2, 8};
        System.out.println(Solution.INSTANCE.maxDiff(nums));
    }

    public enum Solution {
        INSTANCE;

        public int maxDiff(int[] nums) {
            int localMin = nums[0];
            int globalMin = nums[0];
            int localMax = nums[0];
            int globalMax = nums[0];

            for (int i = 1; i < nums.length; i++) {
                localMin = Math.min(localMin + nums[i], nums[i]);
                globalMin = Math.min(globalMin, localMin);
                localMax = Math.max(localMax + nums[i], nums[i]);
                globalMax = Math.max(globalMax, localMax);
            }

            return Math.abs(globalMin - globalMax);
        }
    }
}
