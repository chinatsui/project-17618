package me.chinatsui.algorithm.review.unionfind;

public interface UF {

    int size();

    boolean isConnected(int p, int q);

    int find(int p);

    void union(int p, int q);

}
