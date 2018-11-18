package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public enum BinaryTreeLevelOrderTraversalII {

    INSTANCE;

    public static void main(String[] args) {
        Integer[] input = {3, 9, 20, null, null, 15, 7};
        TreeNode node = BinaryTree.deserializeFromLevelOrder(input);
        List<List<Integer>> res = INSTANCE.levelOrder(node);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        traverse(root, 0, res);
        return res;
    }

    private void traverse(TreeNode node, int level, List<List<Integer>> res) {
        if (node != null) {
            if (level >= res.size()) {
                res.add(new ArrayList());
            }
            res.get(level).add(node.val);
            traverse(node.left, level + 1, res);
            traverse(node.right, level + 1, res);
        }
    }

}
