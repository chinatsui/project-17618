package me.chinatsui.exercise.leetcode.mar;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public enum LowestCommonAncestorBT {

    INSTANCE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(16);

        root.left = new TreeNode(8);
        root.right = new TreeNode(19);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(13);

        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(15);

        System.out.println(INSTANCE.lowestCommonAncestor(root, root.left.left, root.left.right.right));
    }

    private Map<TreeNode, TreeNode> toFromMap = new HashMap();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        Stack<TreeNode> path2p = getPath(root, p);
        Stack<TreeNode> path2q = getPath(root, q);

        for (TreeNode pLCA : path2p) {
            for (TreeNode qLCA : path2q) {
                if (pLCA == qLCA) {
                    return pLCA;
                }
            }
        }

        return null;
    }

    private Stack<TreeNode> getPath(TreeNode src, TreeNode dst) {
        Stack<TreeNode> path = new Stack();

        while (dst != src) {
            TreeNode from = toFromMap.get(dst);
            path.push(from);
            dst = from;
        }
        path.push(src);

        return path;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            toFromMap.put(node.left, node);
            dfs(node.left);
        }

        if (node.right != null) {
            toFromMap.put(node.right, node);
            dfs(node.right);
        }
    }

}
