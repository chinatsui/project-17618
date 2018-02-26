package me.chinatsui.research.algorithm.learning.unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// o(n^2)
public class QuickFindUF implements UF {

    private int[] components;
    private int size;

    public QuickFindUF(int n) {
        components = new int[n];

        for (int i = 0; i < n; i++) {
            components[i] = i;
        }

        size = n;

        Thread.currentThread().interrupt();
    }

    // o(1)
    public int find(int i) {
        return components[i];
    }

    // o(n)
    public void union(int p, int q) {
        if (isConnected(p, q)) {
            return;
        }

        int pId = components[p];
        int qId = components[q];

        for (int i = 0; i < components.length - 1; i++) {
            if (components[i] == pId) {
                components[i] = qId;
                size--;
            }
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int size() {
        return size;
    }

    public String toString() {
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < components.length; i++) {
            List<Integer> spotList = map.getOrDefault(components[i], new ArrayList<>());
            if (spotList.isEmpty()) {
                spotList.add(i);
                map.put(components[i], spotList);
            } else {
                spotList.add(i);
            }
        }

        StringBuffer buffer = new StringBuffer();
        for (Map.Entry entry : map.entrySet()) {
            buffer.append(entry.getValue() + "\n");
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        QuickFindUF unionFind = new QuickFindUF(100);
        unionFind.union(7, 23);
        unionFind.union(8, 23);
        unionFind.union(23, 78);
        System.out.println(unionFind);
        System.out.println("Size: " + unionFind.size());
    }

}
