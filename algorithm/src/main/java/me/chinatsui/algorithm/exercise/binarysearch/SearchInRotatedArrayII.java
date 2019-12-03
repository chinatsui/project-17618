package me.chinatsui.algorithm.exercise.binarysearch;

/**
 * LeetCode 81. Search in Rotated Sorted Array II
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedArrayII {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return false;
        }

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;

            if (target == nums[mi]) {
                return true;
            }

            if (nums[mi] < nums[hi]) {// right is sorted
                if (nums[mi] <= target && target <= nums[hi] ) {
                    return binarySearch(nums, mi, hi, target);
                } else {
                    hi = mi - 1;
                }
            } else if (nums[mi] > nums[hi]) { // left is sorted
                if (nums[lo] <= target && target <= nums[mi]) {
                    return binarySearch(nums, lo, mi, target);
                } else {
                    lo = mi + 1;
                }
            } else {
                hi--;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (target == nums[mi]) {
                return true;
            } else if (target < nums[mi]) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }

        return false;
    }
}
