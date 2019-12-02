package me.chinatsui.algorithm.exercise.array;

/**
 * LeetCode 268. Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 * Input: [3,0,1]
 * Output: 2
 *
 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int n = nums.length + 1;
        int apSum = n * (n - 1) / 2;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        return apSum - sum;
    }
}
