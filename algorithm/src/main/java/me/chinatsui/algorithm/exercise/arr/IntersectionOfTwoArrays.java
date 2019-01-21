package me.chinatsui.algorithm.exercise.arr;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 5};
        int[] nums2 = {2, 3, 6, 7, 7,};
        int[] res = Solution.INSTANCE.intersection(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }

    public enum Solution {
        INSTANCE;

        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> nums2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
            return Arrays.stream(nums1).distinct().filter(e -> nums2Set.contains(e)).toArray();
        }
    }
}
