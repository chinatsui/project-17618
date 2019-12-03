package me.chinatsui.algorithm.exercise.binarysearch;

/**
 * LeetCode 154. Find Minimum in Rotated Sorted Array II
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 * Input: [1,3,5]
 * Output: 1
 *
 * Example 2:
 * Input: [2,2,2,0,1]
 * Output: 0
 *
 * Note:
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */
public class FindMinRotatedSortedArrayII {

    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] > nums[hi]) {
                lo = mi + 1;
            } else if (nums[mi] < nums[hi]) {
                hi = mi;
            } else {
                hi--;
            }
        }

        return nums[lo];
    }
}
