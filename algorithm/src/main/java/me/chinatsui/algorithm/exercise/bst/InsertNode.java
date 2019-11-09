package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode-701
 *
 * Given the root node of a binary search tree (BST) and a value to be inserted into the tree,
 * insert the value into the BST.
 *
 * Return the root node of the BST after the insertion.
 * It is guaranteed that the new value does not exist in the original BST.
 *
 * Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion.
 * You can return any of them.
 *
 * For example,
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * And the value to insert: 5
 * You can return this binary search tree:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * This tree is also valid:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 */
public class InsertNode {

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val <= val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                root.right = insert(root.right, val);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                root.left = insert(root.left, val);
            }
        }

        return root;
    }
}
