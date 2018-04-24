package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.Collections;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(input));
    }

    public int trap(int[] height) {
        int left = 0;
        int leftWall = 0;

        int right = height.length - 1;
        int rightWall = 0;

        int water = 0;
        while (left < right) {
            leftWall = Math.max(leftWall, height[left]);
            rightWall = Math.max(rightWall, height[right]);
            if (leftWall < rightWall) {
                water += (leftWall - height[left]);       // leftWall is smaller than rightWall, so the (leftWall-A[a]) water can be stored
                left++;
            } else {
                water += (rightWall - height[right]);
                right--;
            }
        }
        return water;
    }

}
