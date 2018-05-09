package me.chinatsui.research.algorithm.exercise.leetcode.year_2018;

import java.util.HashSet;
import java.util.Set;

public enum SubSets2 {

    INSTANCE;
    static int count = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int len = nums.length;
        int L = 1 << len; //2^len
        Set<Set<Integer>> result = new HashSet<>();
        for (int i = 0; i < L; i++) {
            Set<Integer> temp = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                    count++;
                }
                result.add(temp);
            }
        }
        System.out.println(count);
        System.out.println(result);
    }

}
