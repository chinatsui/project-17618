package me.chinatsui.algorithm.exercise.bst;

/**
 * LeetCode 215. Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length, p = n - k;
        partition(nums, 0, n -1, p);
        return nums[p];
    }

    private void partition(int[] nums, int lo, int hi, int p) {
        if (lo >= hi) {
            return;
        }

        int sm = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[i] < nums[hi]) {
                swap(nums, sm++, i);
            }
        }

        swap(nums, sm, hi);
        if (sm == p) {
            return;
        }

        if (sm < p) {
            partition(nums, sm + 1, hi, p);
        } else {
            partition(nums, lo, sm - 1, p);
        }
    }

    private void swap(int[] nums, int src, int dst) {
        int tmp = nums[dst];
        nums[dst] = nums[src];
        nums[src] = tmp;
    }
}
