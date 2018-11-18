package me.chinatsui.algorithm.exercise.binary_tree;

import me.chinatsui.algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum LowestCommonAncestorBT {

    INSTANCE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);

        root.left = new TreeNode(0);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(8);

        System.out.println(INSTANCE.lowestCommonAncestor(root, root.left, root.left.left.left));
    }

    private TreeNode root;
    private Map<TreeNode, TreeNode> toFrom = new HashMap();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        this.root = root;
        dfs(root);

        ArrayList<TreeNode> path_to_p = getPathTo(p);
        ArrayList<TreeNode> path_to_q = getPathTo(q);
        path_to_p.retainAll(path_to_q);
        if (path_to_p.size() > 0) {
            return path_to_p.get(0);
        } else {
            return null;
        }
    }

    private void dfs(TreeNode node) {
        if (node.left != null) {
            toFrom.put(node.left, node);
            dfs(node.left);
        }

        if (node.right != null) {
            toFrom.put(node.right, node);
            dfs(node.right);
        }
    }

    private ArrayList<TreeNode> getPathTo(TreeNode node) {
        ArrayList<TreeNode> pathTo = new ArrayList();

        pathTo.add(node);
        while (node != root) {
            TreeNode from = toFrom.get(node);
            pathTo.add(from);
            node = from;
        }

        return pathTo;
    }

}
