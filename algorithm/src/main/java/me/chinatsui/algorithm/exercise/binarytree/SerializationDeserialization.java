package me.chinatsui.algorithm.exercise.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

import me.chinatsui.algorithm.entity.TreeNode;

public class SerializationDeserialization {

    private static final String SPL = ",";
    private static final String NN = "X";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildContent(root, sb);
        return sb.toString();
    }

    private void buildContent(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(SPL);
        } else {
            sb.append(node.val).append(SPL);
            buildContent(node.left, sb);
            buildContent(node.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SPL)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(LinkedList<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
