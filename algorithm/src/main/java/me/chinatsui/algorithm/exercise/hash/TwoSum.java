package me.chinatsui.algorithm.exercise.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * No.1,  [2, 7, 11, 15] 9 -> 0,1
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int[] result = new TwoSum().twoSum(input, 18);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            } else {
                int sub = target - nums[i];
                map.put(sub, i);
            }
        }

        return result;
    }

}
