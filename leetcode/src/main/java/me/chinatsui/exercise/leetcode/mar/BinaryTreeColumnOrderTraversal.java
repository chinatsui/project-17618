package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum BinaryTreeColumnOrderTraversal {

    INSTANCE;

    public List<Integer> traverse(TreeNode root) {
        List<Integer> res = new ArrayList();
        TreeMap<Integer, List<Integer>> history = new TreeMap();
        traverse(root, history, 0);
        for (Map.Entry<Integer, List<Integer>> entry : history.entrySet()) {
            for (Integer val : entry.getValue()) {
                res.add(val);
            }
        }
        return res;
    }

    private void traverse(TreeNode node, TreeMap<Integer, List<Integer>> history, int x) {
        if (node != null) {
            history.putIfAbsent(x, new ArrayList<>());
            history.get(x).add(node.val);
            traverse(node.left, history, x - 1);
            traverse(node.right, history, x + 1);
        }
    }

}
