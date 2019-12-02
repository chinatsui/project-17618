package me.chinatsui.algorithm.exercise.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 421. Maximum XOR of Two Numbers in an Array
 * <p>
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * <p>
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * <p>
 * Could you do this in O(n) runtime?
 * <p>
 * Example:
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 * Explanation: The maximum result is 5 ^ 25 = 28.
 */
public class MaximumXOR {

    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : prefixes) {
                // tmp^num1 == num2, so tmp = num1^num2, then tmp is a potential max
                if (prefixes.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
