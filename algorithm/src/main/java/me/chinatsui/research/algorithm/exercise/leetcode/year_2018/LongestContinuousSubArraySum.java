package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.HashMap;

public enum LongestContinuousSubArraySum {

    INSTANCE;

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 4, 1, 1, 2, 3, -4, 7, 9, 15, 16};
        System.out.println(INSTANCE.getMaxLength(nums, 9));
    }

    public int getMaxLength(int[] nums, int target) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(nums[0], 0);

        int curSum = nums[0];
        int maxLength = 0;
        for (int i = 1; i < nums.length; i++) {
            curSum += nums[i];
            if (preSum.containsKey(curSum - target)) {
                int lastIndex = preSum.get(curSum - target);
                maxLength = Math.max(maxLength, i - lastIndex);
            } else {
                preSum.put(curSum, i);
            }
        }

        return maxLength;
    }

}
