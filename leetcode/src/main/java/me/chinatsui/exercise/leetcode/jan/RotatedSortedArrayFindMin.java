package me.chinatsui.exercise.leetcode.jan;


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

}
