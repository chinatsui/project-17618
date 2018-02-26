package me.chinatsui.research.algorithm.learning.heap;


import me.chinatsui.research.algorithm.utils.DataUtils;

import java.util.Arrays;

public class MinPQ {

    int[] heap;
    int count;

    public MinPQ(int size) {
        heap = new int[size + 1];
    }

    public void insert(int number) {
        int index = ++count;
        heap[index] = number;
        swim(index);
    }

    public int deletePriority() {
        int priority = heap[1];
        exchange(1, count);
        heap[count--] = 0;
        sink(1);
        return priority;
    }

    public int getCount() {
        return count;
    }

    private void swim(int index) {
        int parentIndex = index / 2;
        if (heap[index] < heap[parentIndex]) {
            exchange(parentIndex, index);
            swim(parentIndex);
        }
    }

    private void sink(int index) {
        int leftChildIndex = index * 2;
        int rightChildIndex = index * 2 + 1;

        if (leftChildIndex > count) {
            return;
        }

        if (leftChildIndex == count || heap[leftChildIndex] < heap[rightChildIndex]) {
            if (heap[index] > heap[leftChildIndex]) {
                exchange(index, leftChildIndex);
                sink(leftChildIndex);
            }
        } else {
            if (heap[index] > heap[rightChildIndex]) {
                exchange(index, rightChildIndex);
                sink(rightChildIndex);
            }
        }
    }

    private void exchange(int index1, int index2) {
        int tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }


    public static void main(String[] args) {
        Integer[] nums = DataUtils.getRandomIntegerArray(16);

        System.out.println(Arrays.toString(nums));

        MinPQ minPQ = new MinPQ(30);
        for (Integer num : nums) {
            minPQ.insert(num);
        }

        while (minPQ.getCount() > 0) {
            System.out.print(minPQ.deletePriority() + " ");
        }

    }

}
