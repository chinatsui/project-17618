package me.chinatsui.algorithm.exercise.binarysearch;


public class SqrtDecimal {

    public static void main(String[] args) {
        System.out.println(new SqrtDecimal().mySqrt(1000000));
    }

    public long mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int lo = 1;
        int hi = x;

        while (true) {
            int mid = lo + (hi - lo) / 2;

            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                } else {
                    lo = mid + 1;
                }
            }
        }
    }

}
