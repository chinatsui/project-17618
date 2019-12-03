package me.chinatsui.algorithm.exercise.binarysearch;

/**
 * LeetCode 33. Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] < nums[hi]) {// right is sorted, left is not
                if (nums[mi] <= target && target <= nums[hi] ) {
                    return binarySearch(nums, mi, hi, target);
                } else {
                    hi = mi - 1;
                }
            } else { // left is sorted, right is not
                if (nums[lo] <= target && target <= nums[mi]) {
                    return binarySearch(nums, lo, mi, target);
                } else {
                    lo = mi + 1;
                }
            }
        }

        return -1;
    }

    private int binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (target == nums[mi]) {
                return mi;
            } else if (target < nums[mi]) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }

        return -1;
    }
}
