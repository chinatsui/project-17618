package me.chinatsui.algorithm.exercise.binarysearch;

/**
 * LeetCode 153. Find Minimum in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate startsWith in the array.
 *
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 *
 */
public class FindMinRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] > nums[hi]) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return nums[lo];
    }

}
