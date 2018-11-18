package me.chinatsui.algorithm.exercise.binary_search;

public class RotatedSortedArrayFindMin {

    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] < nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }

        return nums[l];
    }

}
