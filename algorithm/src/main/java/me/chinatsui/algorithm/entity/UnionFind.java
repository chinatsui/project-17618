package me.chinatsui.algorithm.entity;

public abstract class UnionFind {

    protected int[] ids;
    protected int size;

    public UnionFind(int n) {
        ids = new int[n];
        size = n;

        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }
    }

    abstract int find(int p);

    abstract void union(int p, int q);

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int size() {
        return size;
    }

    public static class QuickFindUF extends UnionFind {

        public QuickFindUF(int n) {
            super(n);
        }

        @Override
        int find(int p) {
            return ids[p];
        }

        @Override
        void union(int p, int q) {
            int idp = find(p);
            int idq = find(q);

            if (idp == idq) {
                return;
            }

            for (int i = 0; i < size; i++) {
                if (ids[i] == idp) {
                    ids[i] = idq;
                }
            }
            size--;
        }
    }

    public static class QuickUnionUF extends UnionFind {

        public QuickUnionUF(int n) {
            super(n);
        }

        @Override
        int find(int p) {
            while (p != ids[p]) {
                p = ids[p];
            }

            return p;
        }

        @Override
        void union(int p, int q) {
            int idp = find(p);
            int idq = find(q);

            if (idp == idq) {
                return;
            }

            ids[idp] = idq;
            size--;
        }
    }

    public static class WeightedQuickUnionUF extends QuickUnionUF {

        private int[] weights;

        public WeightedQuickUnionUF(int n) {
            super(n);
            weights = new int[n];
            for (int i = 0; i < size; i++) {
                weights[i] = 1;
            }
        }

        @Override
        void union(int p, int q) {
            int idp = find(p);
            int idq = find(q);

            if (idp == idq) {
                return;
            }

            if (weights[idq] < weights[idp]) {
                ids[idp] = idq;
                weights[idq] += weights[idp];
                weights[idp] = 0;
            } else {
                ids[idq] = idp;
                weights[idp] += weights[idq];
                weights[idq] = 0;
            }
            size--;
        }
    }
}
