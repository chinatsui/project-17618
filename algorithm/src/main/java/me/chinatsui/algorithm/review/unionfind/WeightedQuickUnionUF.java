package me.chinatsui.algorithm.review.unionfind;

import java.util.Arrays;

public class WeightedQuickUnionUF implements UF {

    private int[] components;
    private int[] weights;
    private int size;

    public WeightedQuickUnionUF(int n) {
        components = new int[n];
        weights = new int[n];

        for (int i = 0; i < n; i++) {
            components[i] = i;
            weights[i] = 1;
        }

        size = n;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (p != components[p]) {
            p = components[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pComponent = find(p);
        int qComponent = find(q);

        if (pComponent != qComponent) {
            int pComWeight = weights[pComponent];
            int qComWeight = weights[qComponent];

            if (pComWeight < qComWeight) {
                components[pComponent] = qComponent;
                weights[qComponent] += pComWeight;
            } else {
                components[qComponent] = pComponent;
                weights[pComponent] += qComWeight;
            }

            size--;
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(30);

        uf.union(1, 10);
        uf.union(2, 9);
        uf.union(10, 13);
        uf.union(13, 2);
        uf.union(14, 13);

        assert uf.size() == 25;
        assert uf.isConnected(14, 9);
        assert uf.weights[1] == 6;
        System.out.println(Arrays.toString(uf.components));
        System.out.println(Arrays.toString(uf.weights));
    }

}
