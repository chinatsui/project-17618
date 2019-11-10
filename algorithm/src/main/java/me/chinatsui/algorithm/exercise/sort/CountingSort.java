package me.chinatsui.algorithm.exercise.sort;

/**
 * Assume each number in the array are non-negative.
 */
public class CountingSort extends Sort {

    @Override
    void sort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        int n = nums.length, max = nums[0];

        // find the max number
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
        }

        // construct count array and do stats for nums
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        // accumulate number count in count array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // if count[nums[i]] == k, then nums[i] is the kth biggest number, so its index should be k-1
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            int index = --count[nums[i]];
            tmp[index] = nums[i];
        }

        System.arraycopy(tmp, 0, nums, 0, n);
    }
}
