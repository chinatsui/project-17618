package me.chinatsui.algorithm.exercise.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

import me.chinatsui.algorithm.entity.TreeNode;

public class SerializationDeserialization {

    private static final String SPL = ",";
    private static final String NN = "N";

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        buildContent(root, builder);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    private void buildContent(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(NN).append(SPL);
        } else {
            builder.append(node.val).append(SPL);
            buildContent(node.left, builder);
            buildContent(node.right, builder);
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
