package me.chinatsui.research.algorithm.exercise.leetcode.year_2017;


public class RotatedSortedArraySearch {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        System.out.println(new RotatedSortedArraySearch().search(nums, 0));
    }

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        return search(nums, 0, nums.length - 1, target);
    }

    private boolean search(int[] nums, int lo, int hi, int target) {

        if (lo == hi) {
            return nums[lo] == target;
        }

        int mid = (lo + hi) / 2;

        if (nums[lo] < nums[mid]) {
            // left is sorted
            if (target < nums[lo] || target > nums[mid]) {
                return search(nums, mid + 1, hi, target);
            } else {
                return search(nums, lo, mid, target);
            }
        } else if (nums[lo] > nums[mid]) {
            // right is sorted
            if (target < nums[mid + 1] || target > nums[hi]) {
                return search(nums, lo, mid, target);
            } else {
                return search(nums, mid + 1, hi, target);
            }
        } else {
            if (nums[lo] == target) {
                return true;
            } else {
                return search(nums, ++lo, hi, target);
            }
        }

    }


}
