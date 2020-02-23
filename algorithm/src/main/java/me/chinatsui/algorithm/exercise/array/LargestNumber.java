package me.chinatsui.algorithm.exercise.array;

import java.util.Arrays;

/**
 * LeetCode 179. Largest Number
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return "0";
        }

        int n = nums.length;
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strArr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        String res = String.join("", strArr);
        if (res.charAt(0) == '0') {
            return "0";
        }
        return res;
    }
}
