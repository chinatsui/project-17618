package me.chinatsui.algorithm.exercise.binarysearch;

import org.junit.Test;

/**
 * Try to find the last number less than or equals to the target in a sorted array.
 * <p>
 * Example:
 * nums = [1,2,3,5,6,8,8,8,12,15], target = 7, returns 4
 */
public class SearchInSortedArrayV extends SearchInSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        validate(nums);

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mi = lo + ((hi - lo) >> 1);
            if (nums[mi] <= target) {
                if (mi == nums.length - 1 || nums[mi + 1] > target) {
                    return mi;
                } else {
                    lo = mi + 1;
                }
            } else {
                hi = mi - 1;
            }
        }

        return -1;
    }
}
