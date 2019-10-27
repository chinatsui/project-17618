package me.chinatsui.algorithm.exercise.dp;

/**
 * LeetCode - 674
 * <p>
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 * <p>
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * <p>
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 */
public class LICS {

    public int findLength(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int n = nums.length;
        int old, now;
        int res = old = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                now = old + 1;
            } else {
                now = 1;
            }
            res = Math.max(res, now);
            old = now;
        }

        return res;
    }
}
