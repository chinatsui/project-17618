package me.chinatsui.algorithm.exercise.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LeetCode 347. Top K Frequent Elements
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4};
        List<Integer> result = new TopKFrequentElements().resolve(nums, 2);
        System.out.println(result);
    }

    public List<Integer> resolve(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return new ArrayList<>();
        }

        HashMap<Integer, Integer> frequencies = new HashMap<>();
        int max = 1;
        for (int num : nums) {
            if (frequencies.containsKey(num)) {
                int val = frequencies.get(num);
                val++;
                max = Math.max(max, val);
                frequencies.put(num, val);
            } else {
                frequencies.put(num,  1);
            }
        }

        List<Integer>[] bucket = new List[max + 1];
        frequencies.forEach((key, value) -> {
            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }
            bucket[value].add(key);
        });

        List<Integer> res = new ArrayList<>();
        for (int i = max; i >= 0; i--) {
            if (k < 1) {
                break;
            }

            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    if (k < 1) {
                        break;
                    }
                    res.add(num);
                    k--;
                }
            }
        }

        return res;
    }
}
