package me.chinatsui.exercise.leetcode.mar;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }

        int total = 0;
        Stack<TreeNode> s = new Stack();
        while (!s.empty() || root != null) {
            while (!isLeaf(root)) {
                total += root.val;
                s.push(root);
                root = root.left;
            }

            if (root != null) {
                total += root.val;
                if (total == sum) {
                    ArrayList<Integer> list = new ArrayList();
                    for (TreeNode n : s) {
                        list.add(n.val);
                    }
                    list.add(root.val);
                    res.add(list);
                }
            }

            while (!s.empty() && root == s.peek().right) {
                if (root != null) {
                    total -= root.val;
                }
                root = s.pop();
            }

            if (s.empty()) {
                root = null;
            } else {
                if (root != null) {
                    total -= root.val;
                }
                root = s.peek().right;
            }
        }

        return res;
    }

    private boolean isLeaf(TreeNode node) {
        return node == null ? true : node.left == null && node.right == null;
    }

}
