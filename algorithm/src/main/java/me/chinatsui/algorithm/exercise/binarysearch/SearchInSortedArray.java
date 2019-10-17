package me.chinatsui.algorithm.exercise.binarysearch;

/**
 * Try to find the target number in a sorted array in which there doesn't exist any duplicate numbers.
 */
public class SearchInSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        validate(nums);

        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mi = lo + ((hi - lo) >> 1);
            if (nums[mi] == target) {
                return mi;
            } else if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }

        return -1;
    }

    protected void validate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                throw new IllegalArgumentException("Given nums array is not sorted.");
            }
        }
    }
}
