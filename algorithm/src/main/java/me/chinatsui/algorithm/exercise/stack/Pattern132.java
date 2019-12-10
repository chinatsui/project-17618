package me.chinatsui.algorithm.exercise.stack;

import java.util.Stack;

/**
 * LeetCode 456. 132 Pattern
 * <p>
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak
 * such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks
 * whether there is a 132 pattern in the list.
 * <p>
 * Note: n will be less than 15,000.
 * <p>
 * Example 1:
 * Input: [1, 2, 3, 4]
 * Output: False
 * Explanation: There is no 132 pattern in the sequence.
 * <p>
 * Example 2:
 * Input: [3, 1, 4, 2]
 * Output: True
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * <p>
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * Output: True
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 */
public class Pattern132 {

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int n = nums.length;
        Stack<Integer> s2 = new Stack<>();
        int s3 = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            // s1 refers to nums[i]
            if (nums[i] < s3) {
                return true;
            }

            while (!s2.isEmpty() && nums[i] > s2.peek()) {
                s3 = s2.pop();
            }

            s2.push(nums[i]);
        }

        return false;
    }
}
