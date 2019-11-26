package me.chinatsui.algorithm.exercise.greedy;

/**
 * LeetCode 45 - Jump Game II
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Note: You can assume that you can always reach the last index.
 */
public class JumpGameII {

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length, cur = 0, afterJump = 0, steps = 0;
        while (cur < n && afterJump < n - 1) {
            int furthest = afterJump;
            while (cur <= afterJump) {
                furthest = Math.max(furthest, cur + nums[cur]);
                cur++;
            }
            afterJump = furthest;
            steps++;
        }

        return steps;
    }
}
