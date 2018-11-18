package me.chinatsui.algorithm.review.queue;

public class PriorityQueue implements Queue<Integer> {

    private int[] data = new int[50];
    private int size = 0;

    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.offer(5);
        q.offer(3);
        q.offer(2);
        q.offer(145);
        q.offer(34);
        q.offer(765);
        while (q.size > 0) {
            System.out.println(q.poll());
        }
    }

    @Override
    public void offer(Integer item) {
        data[size++] = item;
        swim(size - 1);
    }

    @Override
    public Integer poll() {
        int result = data[0];
        exchange(0, size - 1);
        data[--size] = 0;
        sink(0);
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private void sink(int index) {
        if (index >= size) {
            return;
        }

        int leftChildIndex = (index + 1) * 2 - 1;
        int rightChildIndex = (index + 1) * 2;

        if (rightChildIndex < size) {
            int prior = prior(leftChildIndex, rightChildIndex);
            if (prior(index, prior) != index) {
                exchange(index, prior);
                sink(prior);
            }
        } else if (leftChildIndex < size) {
            if (prior(index, leftChildIndex) != index) {
                exchange(index, leftChildIndex);
                sink(leftChildIndex);
            }
        } else {
            return;
        }

    }

    private void swim(int index) {
        if (index == 0) {
            return;
        }

        int parentIndex = (index - 1) / 2;

        if (prior(index, parentIndex) == index) {
            exchange(index, parentIndex);
            swim(parentIndex);
        }
    }

    private int prior(int srcIndex, int dstIndex) {
        return data[srcIndex] < data[dstIndex] ? srcIndex : dstIndex;
    }

    private void exchange(int srcIndex, int dstIndex) {
        int tmp = data[srcIndex];
        data[srcIndex] = data[dstIndex];
        data[dstIndex] = tmp;
    }

}
