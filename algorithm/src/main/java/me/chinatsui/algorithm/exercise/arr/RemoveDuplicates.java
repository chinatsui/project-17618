package me.chinatsui.algorithm.exercise.arr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public enum RemoveDuplicates {

    INSTANCE;

    public static void main(String[] args) {
        int[] x = {1, 2, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 6, 7};
//        System.out.println(INSTANCE.removeDuplicates(x));
        System.out.println(Arrays.toString(x));
        List list = Arrays.stream(x).boxed().collect(Collectors.toList());
        System.out.println(list.size());
        HashSet<Integer> set = new HashSet(list);
        System.out.println(set.size());
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int n = nums.length;
        int prev = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[prev]) {
                nums[++prev] = nums[i];
            }
        }
        return ++prev;
    }

}
