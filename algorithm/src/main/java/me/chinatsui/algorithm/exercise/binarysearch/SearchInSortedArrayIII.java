package me.chinatsui.algorithm.exercise.binarysearch;

/**
 * Try to find the last number equals to target in a sorted array in which there exists duplicate numbers.
 * <p>
 * Example:
 * nums = [1,2,3,5,7,8,8,8,12,15], target = 8, returns 7.
 */
public class SearchInSortedArrayIII extends SearchInSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        validate(nums);

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mi = lo + ((hi - lo) >> 1);
            if (nums[mi] == target) {
                if (mi == nums.length - 1 || nums[mi + 1] > target) {
                    return mi;
                } else {
                    lo = mi + 1;
                }
            } else if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }

        return -1;
    }
}
