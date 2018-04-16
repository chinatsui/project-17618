package me.chinatsui.research.algorithm.exercise.leetcode.year_2017;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chinatsui on 15/01/2018.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }

        List<TreeNode> nodeList = new ArrayList();

        inOrderTraverse(treeNode, nodeList);

        TreeNode prev = nodeList.get(0);
        for (int i = 1; i < nodeList.size(); i++) {
            TreeNode cur = nodeList.get(i);
            if (prev.val >= cur.val) {
                return false;
            }
            prev = cur;
        }

        return true;
    }

    private void inOrderTraverse(TreeNode treeNode, List<TreeNode> nodeList) {
        if (treeNode.left != null) {
            inOrderTraverse(treeNode.left, nodeList);
        }

        nodeList.add(treeNode);

        if (treeNode.right != null) {
            inOrderTraverse(treeNode.right, nodeList);
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
