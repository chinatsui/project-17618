package me.chinatsui.algorithm.exercise.bit;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 31));
    }

    public int reverse(int n) {
        if (n == 0) return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }
}
