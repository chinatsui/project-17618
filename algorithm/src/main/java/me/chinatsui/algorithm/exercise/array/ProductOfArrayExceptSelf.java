package me.chinatsui.algorithm.exercise.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] input = new int[]{2, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(input)));
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }

        int n = nums.length;
        int[] res = new int[n];

        // From left to right, res[i] (i starts from 1) = multiply of all elements before i.
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // From right to left, uses res[0] to store the multiply of all elements from n - 1 to j + 1,
        // Previously we have calculated multiply from 0 to j - 1, now we have multiply of j + 1 to n - 1,
        // So we can easily update res[j];
        res[0] = nums[n - 1];
        for (int j = n - 2; j > 0; j--) {
            res[j] *= res[0];
            res[0] *= nums[j];
        }
        return res;
    }
}
