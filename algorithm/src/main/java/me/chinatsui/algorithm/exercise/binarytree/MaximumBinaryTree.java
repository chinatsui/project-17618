package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode 654. Maximum Binary Tree
 *
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * 1. The root is the maximum number in the array.
 * 2. The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * 3. The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 *
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 * Note:
 * The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }

        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        if (lo == hi) {
            return new TreeNode(nums[lo]);
        }

        int max = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }

        TreeNode root = new TreeNode(nums[max]);
        root.left = build(nums, lo, max - 1);
        root.right = build(nums, max + 1, hi);
        return root;
    }
}
