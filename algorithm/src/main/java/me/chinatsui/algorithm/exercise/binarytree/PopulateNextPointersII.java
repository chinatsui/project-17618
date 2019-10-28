package me.chinatsui.algorithm.exercise.binarytree;

/**
 * LeetCode - 117
 *
 * Given a binary tree
 *
 * TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 *
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 *
 * Example:
 *
 * Given the following binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *    \    \
 *     5    7
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *    \    \
 *     5 -> 7 -> NULL
 */
public class PopulateNextPointersII extends PopulateNextPointers {

    public void populate(Node root) {
        Node rowHead = root;
        while (rowHead != null) {
            Node rowNow = rowHead;
            Node childNow = null;

            // connect next pointers for current level.
            while (rowNow != null) {
                if (rowNow.left != null) {
                    childNow = rowNow.left;
                    if (rowNow.right != null) {
                        childNow.next = rowNow.right;
                        childNow = childNow.next;
                    }
                } else if (rowNow.right != null){
                    childNow = rowNow.right;
                }

                if (rowNow.next != null) {
                    if (childNow != null) {
                        if (rowNow.next.left != null) {
                            childNow.next = rowNow.next.left;
                        } else if (rowNow.next.right != null) {
                            childNow.next = rowNow.next.right;
                        }
                    }
                }

                rowNow = rowNow.next;
            }

            // find the head node for next level.
            Node nextRowHead = null;
            while (nextRowHead == null) {
                if (rowHead.left != null) {
                    nextRowHead = rowHead.left;
                } else {
                    nextRowHead = rowHead.right;
                }

                if (rowHead.next == null) {
                    break;
                } else {
                    rowHead = rowHead.next;
                }
            }
            rowHead = nextRowHead;
        }
    }
}
