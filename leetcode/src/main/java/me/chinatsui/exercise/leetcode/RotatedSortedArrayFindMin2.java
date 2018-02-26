package me.chinatsui.exercise.leetcode;


public class RotatedSortedArrayFindMin2 {

    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        if (nums[lo] < nums[hi]) {
            return nums[lo];
        }

        int mid = (lo + hi) / 2;

        if (nums[lo] < nums[mid]) {
            return findMin(nums, mid + 1, hi);
        } else if (nums[lo] > nums[mid]) {
            return findMin(nums, lo, mid);
        } else {
            return findMin(nums, ++lo, hi);
        }
    }

}
