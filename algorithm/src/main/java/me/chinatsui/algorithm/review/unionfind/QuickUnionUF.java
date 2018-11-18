package me.chinatsui.algorithm.review.unionfind;

// o(n^2)
public class QuickUnionUF implements UF {

    private int[] components;
    private int size;

    public QuickUnionUF(int count) {
        components = new int[size];
        size = count;

        for (int i = 0; i < size; i++) {
            components[i] = i;
        }
    }

    public int size() {
        return size;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // o(tree-height)
    public int find(int p) {
        while (p != components[p]) {
            p = components[p];
        }

        return p;
    }

    // o(tree-height)
    public void union(int p, int q) {
        int pComponent = find(p);
        int qComponent = find(q);

        if (pComponent != qComponent) {
            components[pComponent] = qComponent;
            size--;
        }
    }

    /*
     * To be finished smarter in the future.
     * For now, I don't want to iterate the component array which will have duplicate access for the same spot.
     */

//    public String toString() {
//
//    }

}
