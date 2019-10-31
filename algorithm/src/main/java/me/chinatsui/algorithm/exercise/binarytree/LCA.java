package me.chinatsui.algorithm.exercise.binarytree;


import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LintCode-88
 *
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 *
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 *
 * Example
 *
 * Example 1:
 * Input：{1},1,1
 * Output：1
 * Explanation：
 *  For the following binary tree（only one node）:
 *          1
 *  LCA(1,1) = 1
 *
 * Example 2:
 * Input：{4,3,7,#,#,5,6},3,5
 * Output：4
 * Explanation：
 *  For the following binary tree:
 *
 *       4
 *      / \
 *     3   7
 *        / \
 *       5   6
 *
 *  LCA(3, 5) = 4
 */
public class LCA {

    public TreeNode resolve(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }

        if (root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = resolve(root.left, p, q);
        TreeNode right = resolve(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }
}
