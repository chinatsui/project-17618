package me.chinatsui.algorithm.exercise.bit;

public class BitMap {
    private int[] bytes;
    private int bits;

    public BitMap(int bits) {
        this.bits = bits;
        this.bytes = new int[bits / 32 + 1];
    }

    public void set(int k) {
        if (k > bits || k < 0)
            return;
        int byteIndex = k / 32;
        int bitOffset = k % 32;
        bytes[byteIndex] |= (1 << bitOffset);
    }

    public boolean exists(int k) {
        if (k > bits || k < 0)
            return false;
        int byteIndex = k / 32;
        int bitOffset = k % 32;
        return (bytes[byteIndex] & (1 << bitOffset)) != 0;
    }
}

