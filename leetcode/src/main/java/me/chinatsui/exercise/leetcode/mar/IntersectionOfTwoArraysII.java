package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1, 1};
        int[] res = new IntersectionOfTwoArraysII().intersect(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums1).forEach(e -> {
            map.putIfAbsent(e, 1);
            map.put(e, map.get(e) + 1);
        });

        Arrays.stream(nums2).forEach(e -> {
            if (map.containsKey(e) && map.get(e) > 0) {
                res.add(e);
                map.put(e, map.get(e) - 1);
            }
        });

        return Arrays.stream(res.toArray(new Integer[0])).mapToInt(i->i).toArray();
    }

}
