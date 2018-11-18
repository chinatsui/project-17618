package me.chinatsui.algorithm.review.heap;


import me.chinatsui.algorithm.util.DataUtils;

import java.util.Arrays;

public class MinPQ {

    private final int[] heap;
    int size;

    public MinPQ(int size) {
        heap = new int[size];
        this.size = 0;
    }

    public void offer(int number) {
        int idx = size++;
        heap[idx] = number;
        swim(idx);
    }

    public int poll() {
        int res = heap[0];
        swap(0, size - 1);
        heap[--size] = 0;
        sink(0);
        return res;
    }

    public int getSize() {
        return size;
    }

    private void swim(int index) {
        int parentIndex = (index - 1) / 2;
        if (heap[index] < heap[parentIndex]) {
            swap(parentIndex, index);
            swim(parentIndex);
        }
    }

    private void sink(int idx) {
        int leftIdx = (idx + 1) * 2 - 1;
        int rightIdx = (idx + 1) * 2;

        if (leftIdx > size - 1) {
            return;
        }

        if (leftIdx == size - 1 || heap[leftIdx] < heap[rightIdx]) {
            if (heap[idx] > heap[leftIdx]) {
                swap(idx, leftIdx);
                sink(leftIdx);
            }
        } else {
            if (heap[idx] > heap[rightIdx]) {
                swap(idx, rightIdx);
                sink(rightIdx);
            }
        }
    }

    private void swap(int index1, int index2) {
        int tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }


    public static void main(String[] args) {
        System.out.println(-1 / 2);
        Integer[] nums = DataUtils.getRandomIntegerArray(16);

        System.out.println(Arrays.toString(nums));

        MinPQ minPQ = new MinPQ(30);
        for (Integer num : nums) {
            minPQ.offer(num);
        }

        while (minPQ.getSize() > 0) {
            System.out.print(minPQ.poll() + " ");
        }
    }

}
