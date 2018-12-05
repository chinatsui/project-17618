package me.chinatsui.algorithm.exercise.arr;

import java.util.HashMap;
import java.util.Map;

public class MaximumContiguousSubArraySum {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 4, 1, 1, 2, 3, 1, -1, -4, 7, 9, 15, 16, 1, -1};
        System.out.println(Solution.INSTANCE.getMaxLength(nums, 9));
    }

    public enum Solution {
        INSTANCE;

        public int getMaxLength(int[] nums, int target) {
            if (nums == null || nums.length < 1) {
                return 0;
            }

            Map<Integer, Integer> cache = new HashMap<>();
            cache.put(0, -1);

            int length = 0;
            int curSum = 0;
            for (int i = 0; i < nums.length; i++) {
                curSum += nums[i];

                int sumDiff = curSum - target;
                if (cache.containsKey(sumDiff)) {
                    length = Math.max(i - cache.get(sumDiff), length);
                }

                if (!cache.containsKey(curSum)) {
                    cache.put(curSum, i);
                }
            }

            return length;
        }
    }
}
