package me.chinatsui.algorithm.exercise.arr;

public class MaximumContiguousSubArraySum {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 4, 1, 1, 2, 3, -4, 7, 9, 15, 16};
        System.out.println(Solution.INSTANCE.getMaxLength(nums, 9));
    }

    public enum Solution {
        INSTANCE;

        public int getMaxLength(int[] nums, int target) {
            int max = 0;
            int sum = 0;
            for (int i = 0, j = 0; i < nums.length; i++) {
                sum += nums[i];
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
}
