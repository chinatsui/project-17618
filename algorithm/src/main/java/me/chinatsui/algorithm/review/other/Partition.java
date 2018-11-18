package me.chinatsui.algorithm.review.other;

public enum Partition {

    INSTANCE;

    public int partition(int[] data, int l, int h) {
        int sm = -1;
        int pivot = h;
        for (int i = l; i < h; i++) {
            if (data[i] < data[pivot]) {
                sm++;
                if (i != sm) {
                    exchange(data, i, sm);
                }
            }
        }
        exchange(data, sm + 1, pivot);
        return sm + 1;
    }

    public int partition(int[] data, int l, int h, int key) {
        int sm = -1;

        for (int i = l; i <= h; i++) {
            if (data[i] < key) {
                sm++;
                if (sm != i) {
                    exchange(data, sm, i);
                }
            }
        }

        return sm;
    }

    private void exchange(int[] data, int src, int dst) {
        int tmp = data[dst];
        data[dst] = data[src];
        data[src] = tmp;
    }

}
