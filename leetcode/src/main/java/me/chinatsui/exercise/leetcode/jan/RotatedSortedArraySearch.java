package me.chinatsui.exercise.leetcode.jan;


public class RotatedSortedArraySearch {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int lo, int hi, int target) {

        if (lo == hi) {
            return nums[lo] == target ? lo : -1;
        }

        int mi = (lo + hi) / 2;

        int left = nums[lo];
        int right = nums[hi];
        int key = nums[mi];

        if (key == target) {
            return mi;
        }

        if (left == target) {
            return lo;
        }

        if (right == target) {
            return hi;
        }

        if (isLeft(left, key, right, target)) {
            return search(nums, lo, mi, target);
        } else {
            return search(nums, mi + 1, hi, target);
        }

    }

    private boolean isLeft(int left, int key, int right, int target) {
        if (target < key && target > left && target < right) {
            return true;
        }

        if (target > key && target > left && target > right) {
            return key < right;
        }

        if (target < key && target < right && target < left) {
            return key < right;
        }

        if (target < key && target > left && target > right) {
            return true;
        }

        return false;
    }

}
