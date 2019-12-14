package me.chinatsui.algorithm.exercise.array;

/**
 * LeetCode 665. Non-decreasing Array
 *
 * Given an array with n integers, your task is to check if it could become non-decreasing
 * by modifying at most 1 element.
 *
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 *
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 *
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 *
 * Note: The n belongs to [1, 10,000].
 */
public class NonDecreasingArray {

    public boolean isAlmostOrdered(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }

        int j = -1, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (j != -1) {
                    // found second j, have to return false
                    return false;
                }
                j = i;
            }
        }

        // j == -1 : the array is already non-decreasing
        // j == 0 and j == nums.length - 2 : we can just modify the element at 0 and n - 1
        if (j <= 0 || j == n - 2) {
            return true;
        }

        // we can always modify j or j + 1 to make it no-decreasing
        if (nums[j - 1] <= nums[j + 1] || nums[j] <= nums[j + 2]) {
            return true;
        }

        return false;
    }
}
