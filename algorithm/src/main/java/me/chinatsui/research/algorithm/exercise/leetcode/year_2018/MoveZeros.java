package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 0, 3, 0, 12};
//        int[] nums = {1};
        Solution.INSTANCE.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public enum Solution {
        INSTANCE;

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
}
