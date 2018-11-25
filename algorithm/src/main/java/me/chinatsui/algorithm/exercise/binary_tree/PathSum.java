package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(Solution.INSTANCE.hasPathSum(root, 22));
    }

    public enum Solution {
        INSTANCE;

        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }

            if (isLeaf(root)) {
                return root.val == sum;
            }

            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }

        private boolean isLeaf(TreeNode node) {
            if (node == null) {
                return true;
            }

            if (node.left == null && node.right == null) {
                return true;
            }

            return false;
        }
    }

}
