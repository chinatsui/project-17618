package me.chinatsui.algorithm.exercise.arr;

import java.util.HashMap;

public enum MaximumSizeContiguousSubArraySum {

    INSTANCE;

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 4, 1, 1, 2, 3, -4, 7, 9, 15, 16};
        System.out.println(INSTANCE.getMaxLength(nums, 9));
        System.out.println(INSTANCE.getMaxLength2(nums, 9));
    }

    public int getMaxLength(int[] nums, int target) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(nums[0], 0);

        int curSum = nums[0];
        int maxLength = nums[0] == target ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            curSum += nums[i];
            if (preSum.containsKey(curSum - target)) {
                int lastIndex = preSum.get(curSum - target);
                maxLength = Math.max(maxLength, i - lastIndex);
            }
            preSum.put(curSum, i);
        }

        return maxLength;
    }

    public int getMaxLength2(int[] nums, int target) {
        int max = 0;
        int sum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            sum +=nums[i];
            if (sum == target) {
                if (max == 0) {
                    max = i - j + 1;
                } else {
                    max = Math.max(max, i - j + 1);
                }
            }

            while (sum > target) {
                sum -= nums[j++];
                if (sum == target) {
                    max = Math.max(max, i - j + 1);
                }
            }
        }

        return max;
    }

}
