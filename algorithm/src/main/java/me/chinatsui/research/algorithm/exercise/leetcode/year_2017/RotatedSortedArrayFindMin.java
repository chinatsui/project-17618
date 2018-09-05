package me.chinatsui.research.algorithm.exercise.leetcode.year_2017;


public class RotatedSortedArrayFindMin {

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        int mid = (lo + hi) / 2;

        int right = nums[hi];
        int key = nums[mid];

        if (key < right) {
            return findMin(nums, lo, mid);
        } else {
            return findMin(nums, mid + 1, hi);
        }
    }

    public int findMin_2(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        return findMin_2(nums, 0, nums.length - 1);
    }

    private int findMin_2(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        if (nums[lo] < nums[hi]) {
            return nums[lo];
        }

        int mid = (lo + hi) / 2;

        if (nums[lo] < nums[mid]) {
            return findMin_2(nums, mid + 1, hi);
        } else if (nums[lo] > nums[mid]) {
            return findMin_2(nums, lo, mid);
        } else {
            return findMin_2(nums, ++lo, hi);
        }
    }

}
