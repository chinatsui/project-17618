package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

public enum RotatedSortedArraySearch2 {

    INSTANCE;

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 2, 1, 1, 1};
        System.out.println(INSTANCE.search(nums, 2));;
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int p = getPivot(nums);
        int l = 0;
        int h = nums.length - 1;

        if (nums[p] <= target && target <= nums[h]) {
            return binarySearch(nums, p, h, target);
        } else if (p == 0) {
            return binarySearch(nums, p, h, target);
        } else if (nums[l] <= target && target <= nums[p - 1]) {
            return binarySearch(nums, l, p - 1, target);
        }

        return false;
    }

    private int getPivot(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] < nums[h]) {
                h = m;
            } else if (nums[m] > nums[h]) {
                l = m + 1;
            } else {
                h--;
            }
        }

        return l;
    }

    private boolean binarySearch(int[] nums, int l, int h, int target) {
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] == target) {
                return true;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return nums[l] == target;
    }

}
