package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.entity.TreeNode;

/**
 * LeetCode-106
 * <p>
 * Given inorder and postorder traversal of a tree, deserialize the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * inorder = [9,3,15,20,7]
 * postorder = [9,15,7,20,3]
 * <p>
 * Return the following binary tree:
 * <p>
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 */
public class ConstructBinaryTree {

    public TreeNode construct(int[] inorder, int[] postorder) {
        validate(inorder, postorder);
        int n = inorder.length, m = postorder.length;
        return construct(inorder, 0, n - 1, postorder, m - 1);
    }

    private TreeNode construct(int[] inorder, int inStart, int inEnd, int[] postorder, int k) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[k]);
        if (inStart == inEnd) {
            return root;
        }

        int p = inStart;
        for (; p <= inEnd; p++) {
            if (inorder[p] == postorder[k]) {
                break;
            }
        }

        root.left = construct(inorder, inStart, p - 1, postorder, k - (inEnd - p) - 1);
        root.right = construct(inorder, p + 1, inEnd, postorder, k - 1);

        return root;
    }

    private void validate(int[] inorder, int[] postorder) {
        assert inorder != null && postorder != null;
        assert inorder.length > 0 && postorder.length > 0;
        assert inorder.length == postorder.length;
    }
}
