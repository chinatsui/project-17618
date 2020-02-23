package me.chinatsui.algorithm.exercise.dp;


import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode-300
 * <p>
 * Given an unsorted array of integers, find the length of longest increasing sub sequence.
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing sub sequence is [2,3,7,101], therefore the length is 4.
 * <p>
 * Note:
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

    public enum Solution {
        /*
        The "tails" is an ArrayList storing the smallest "last element"
        of all increasing subsequences with the given length.

        For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:
        len = 1   :    [4], [5], [6], [3]        => min: 3, tails[0] = 3
        len = 2   :    [4,5], [4,6], [5,6]       => min: 5, tails[1] = 5
        len = 3   :    [4,5,6]                   => min: 6, tails[2] = 6
        And, we can easily prove that the "tails" is an increasing ArrayList also.

        For each time we access the number in nums, we just binary contains it in tails,
        if it is larger than any existent tail, then append it to the tails,
        otherwise we update it in the corresponding position.

        Finally, the size of tails is the length of the longest increasing subsequence.
        (This is indeed hard to be thought of, but it surely is.)
        */
        INSTANCE;

        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }

            List<Integer> tails = new ArrayList<>();

            for (int num : nums) {
                int index = binarySearch(tails, num);
                if (index == tails.size()) {
                    tails.add(num);
                } else {
                    tails.set(index, num);
                }
            }

            return tails.size();
        }

        private int binarySearch(List<Integer> tails, int num) {
            if (tails.size() < 1) {
                return 0;
            }

            int lo = 0, hi = tails.size() - 1;
            while (lo <= hi) {
                int mi = lo + (hi - lo) / 2;
                if (tails.get(mi) >= num) {
                    if (mi == 0 || tails.get(mi - 1) < num) {
                        return mi;
                    } else {
                        hi = mi - 1;
                    }
                } else {
                    lo = mi + 1;
                }
            }

            return tails.size();
        }
    }

    public enum Solution2 {
        INSTANCE;

        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length < 1) {
                return 0;
            }

            int n = nums.length;

            // dp[i] means the longest sub sequence ends with nums[i]
            int[] dp = new int[n];
            dp[0] = 1;

            int max = 1;
            for (int i = 1; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }
}
