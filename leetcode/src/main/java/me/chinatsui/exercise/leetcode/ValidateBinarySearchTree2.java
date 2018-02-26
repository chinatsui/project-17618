package me.chinatsui.exercise.leetcode;

/**
 * Created by chinatsui on 15/01/2018.
 */
public class ValidateBinarySearchTree2 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        System.out.println(new ValidateBinarySearchTree2().isValidBST(node1));
    }

    private int minValue = Integer.MIN_VALUE;
    private boolean minAssigned = false;

    public boolean isValidBST(TreeNode treeNode) {
        int lastValue = Integer.MIN_VALUE;

        if (treeNode == null) {
            return true;
        }

        try {
            inOrderTraverse(treeNode);
        } catch (RuntimeException e) {
            return false;
        }

        return true;
    }

    private void inOrderTraverse(TreeNode treeNode) {
        // left tree
        if (treeNode.left != null) {
            inOrderTraverse(treeNode.left);
        }

        // root
        if (treeNode.val <= minValue && minAssigned) {
            throw new RuntimeException("");
        } else {
            minValue = treeNode.val;
            minAssigned = true;
        }

        // right tree
        if (treeNode.right != null) {
            inOrderTraverse(treeNode.right);
        }
    }

    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

}
