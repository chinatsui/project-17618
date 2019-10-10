package me.chinatsui.algorithm.exercise.binarysearch;

/**
 * LeetCode-33
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to contains. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] > nums[hi]) { // left is sorted
                if (nums[lo] <= target && target <= nums[mi]) {
                    return search(nums, lo, mi, target);
                } else {
                    lo = mi + 1;
                }
            } else { // right is sorted
                if (nums[mi] <= target && target <= nums[hi]) {
                    return search(nums, mi, hi, target);
                } else {
                    hi = mi - 1;
                }
            }
        }
        return nums[lo] == target ? lo : -1;
    }

    private int search(int[] nums, int lo, int hi, int target) {
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] == target) {
                return mi;
            } else if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }

        return nums[lo] == target ? lo : -1;
    }
}
