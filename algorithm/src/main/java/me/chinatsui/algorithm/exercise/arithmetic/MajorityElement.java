package me.chinatsui.algorithm.exercise.arithmetic;

/**
 * LeetCode 169. Majority Element
 *
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += res == num ? 1 : -1;
        }
        return res;
    }
}
