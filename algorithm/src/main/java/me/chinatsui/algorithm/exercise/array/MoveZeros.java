package me.chinatsui.algorithm.exercise.array;

/**
 * LeetCode-283
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && j == -1) {
                j = i;
            } else if (nums[i] != 0 && j != -1) {
                exchange(nums, j++, i);
            }
        }
    }

    private void exchange(int[] nums, int src, int dst) {
        int tmp = nums[src];
        nums[src] = nums[dst];
        nums[dst] = tmp;
    }
}
