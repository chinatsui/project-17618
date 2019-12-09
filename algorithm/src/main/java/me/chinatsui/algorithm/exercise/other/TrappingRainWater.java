package me.chinatsui.algorithm.exercise.other;

/**
 * LeetCode 42. Trapping Rain Water
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * <p>
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int lo = 0, hi = height.length - 1;
        int leftWall = 0, rightWall = 0;
        int water = 0;

        while (lo < hi) {
            leftWall = Math.max(leftWall, height[lo]);
            rightWall = Math.max(rightWall, height[hi]);
            if (leftWall < rightWall) {
                water += leftWall - height[lo];
                lo++;
            } else {
                water += rightWall - height[hi];
                hi--;
            }
        }

        return water;
    }
}
