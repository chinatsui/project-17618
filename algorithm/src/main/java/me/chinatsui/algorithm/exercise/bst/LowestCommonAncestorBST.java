package me.chinatsui.algorithm.exercise.bst;

import me.chinatsui.algorithm.entity.TreeNode;

public enum LowestCommonAncestorBST {

    INSTANCE;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            int val = root.val;
            int min = Math.min(p.val, q.val);
            int max = Math.max(p.val, q.val);

            if (min <= val && val <= max) {
                return root;
            } else if (val < min) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return null;
    }
}
