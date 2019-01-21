package me.chinatsui.algorithm.exercise.arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 3};
        int[] nums2 = {1, 1, 1, 2, 2, 2, 3, 3, 4};
        int[] res = Solution.INSTANCE.intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public enum Solution {
        INSTANCE;

        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> res = new ArrayList<>();

            HashMap<Integer, Integer> map = new HashMap<>();
            Arrays.stream(nums1).forEach(e -> {
                int cnt = map.getOrDefault(e, 0);
                map.put(e, cnt + 1);
            });

            Arrays.stream(nums2).forEach(e -> {
                if (map.containsKey(e)) {
                    int cnt = map.get(e);
                    if (cnt > 0) {
                        res.add(e);
                        map.put(e, cnt - 1);
                    }
                }
            });

            return Arrays.stream(res.toArray(new Integer[res.size()])).mapToInt(i -> i).toArray();
        }
    }
}
