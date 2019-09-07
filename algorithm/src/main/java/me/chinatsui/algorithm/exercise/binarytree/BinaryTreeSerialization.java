package me.chinatsui.algorithm.exercise.binarytree;

import me.chinatsui.algorithm.util.TreeNodes;
import me.chinatsui.algorithm.entity.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeSerialization {

    private static final String SPL = ",";
    private static final String NN = "X";

    public static void main(String[] args) {
        String data = Solution.INSTANCE.serialize(TreeNodes.getBinarySearchTree());
        System.out.println(data);
        Solution.INSTANCE.deserialize(data);
    }

    public enum Solution {
        INSTANCE;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NN).append(SPL);
            } else {
                sb.append(node.val).append(SPL);
                buildString(node.left, sb);
                buildString(node.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(SPL)));
            return buildTree(nodes);
        }

        private TreeNode buildTree(LinkedList<String> nodes) {
            String val = nodes.remove();
            if (val.equals(NN)) {
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.valueOf(val));
                node.left = buildTree(nodes);
                node.right = buildTree(nodes);
                return node;
            }
        }
    }
}
