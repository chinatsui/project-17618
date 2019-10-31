package me.chinatsui.algorithm.exercise.skiplist;

public class SkipList {

    private static final int MAX_LEVEL = 16;
    private static final double PROBABILITY = 0.5f;
    private Node head = new Node(0);
    private int levels;

    public Node search(int val) {
        Node cur = head;
        for (int i = levels - 1; i >= 0; i--) {
            while (cur.forwards[i] != null && cur.forwards[i].val < val) {
                cur = cur.forwards[i];
            }
        }

        if (cur.forwards[0] != null && cur.forwards[0].val == val) {
            return cur.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int val) {
        int level = random();
        Node node = new Node(val);
        Node cur = head;
        for (int i = level - 1; i >= 0; i--) {
            while (cur.forwards[i] != null && cur.forwards[i].val < node.val) {
                cur = cur.forwards[i];
            }
            node.forwards[i] = cur.forwards[i];
            cur.forwards[i] = node;
        }

        levels = Math.max(levels, level);
    }

    public void delete(int val) {
        Node cur = head;
        for (int i = levels - 1; i >= 0; i--) {
            while (cur.forwards[i] != null && cur.forwards[i].val < val) {
                cur = cur.forwards[i];
            }

            // found node, so delete it by up bottom.
            if (cur.forwards[i] != null && cur.forwards[i].val == val) {
                for (int j = i; j >= 0; j--) {
                    Node forward = cur.forwards[j];
                    // loop for nodes with same values on the current level.
                    while (forward.forwards[i].val == val) {
                        forward = forward.forwards[j];
                    }
                    cur.forwards[j] = forward.forwards[j];
                }
                break;
            }
        }

        while (levels > 0 && head.forwards[levels] == null) {
            levels--;
        }
    }

    private static int random() {
        int level = 1;
        while (Math.random() < PROBABILITY && level <= MAX_LEVEL) {
            level++;
        }
        return level;
    }

    static class Node {
        int val;
        Node[] forwards;

        Node(int val) {
            this.val = val;
            this.forwards = new Node[MAX_LEVEL];
        }
    }
}
