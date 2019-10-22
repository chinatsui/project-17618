package me.chinatsui.algorithm.exercise.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import me.chinatsui.algorithm.entity.TreeNode;

public class LowestCommonAncestor {

    private TreeNode root;
    private Map<TreeNode, TreeNode> toFrom = new HashMap<>();

    public LowestCommonAncestor(TreeNode root) {
        this.root = root;
    }

    public TreeNode find(TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

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
        ArrayList<TreeNode> pathTo = new ArrayList<>();

        pathTo.add(node);
        while (node != root) {
            TreeNode from = toFrom.get(node);
            pathTo.add(from);
            node = from;
        }

        return pathTo;
    }
}
