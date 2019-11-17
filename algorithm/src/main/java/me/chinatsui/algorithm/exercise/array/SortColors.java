package me.chinatsui.algorithm.exercise.array;

/**
 * LeetCode-75
 * <p>
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * <p>
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {

    public void sort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        // p1 - the position in which color 1 maybe put for now
        // p2 - the position in which color 2 would be put in the future
        int p1 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            if (nums[i] == 2) {
                // because we don't know what color is swapped to position i, so we need to re-check it once.
                // if it is zero, then we need to swap it with p1 for next round, so i must be minus -1 for re-check.
                swap(nums, i--, p2--);
            } else if (nums[i] == 0) {
                // because we are for sure aware of that either 1 or 0 would be swapped to position i, the two cases
                // are both expected to put in position i, and not need to re-check it, so won't do i--.
                swap(nums, i, p1++);
            }
        }
    }

    private void swap(int[] nums, int src, int dst) {
        int tmp = nums[src];
        nums[src] = nums[dst];
        nums[dst] = tmp;
    }
}
