package me.chinatsui.exercise.leetcode.mar;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] input = {2, 0, 2};
        System.out.println(new TrappingRainWater().trap(input));
    }

    public int trap(int[] height) {

        if (height == null) {
            return 0;
        }

        int water = 0;
        int n = height.length;

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
            }
        }

        for (int i = 0; i < maxHeight; i++) {
            int[] copy = new int[n];
            System.arraycopy(height, 0, copy, 0, n);
            for (int j = 0; j < n; j++) {
                copy[j] = Math.max(0, copy[j] - i);
            }
            water += rainLevel(copy);
        }

        return water;
    }

    private int rainLevel(int[] level) {
        int water = 0;
        int n = level.length;

        int first = -1;
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (first == -1 && level[i] > 0) {
                first = i;
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (last == -1 && level[i] > 0) {
                last = i;
                break;
            }
        }

        for (int i = first + 1; i < last; i++) {
            if (level[i] == 0) {
                water++;
            }
        }

        return water;
    }

}
