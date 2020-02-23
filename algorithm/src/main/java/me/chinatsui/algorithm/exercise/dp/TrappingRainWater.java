package me.chinatsui.algorithm.exercise.dp;

public class TrappingRainWater {

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
