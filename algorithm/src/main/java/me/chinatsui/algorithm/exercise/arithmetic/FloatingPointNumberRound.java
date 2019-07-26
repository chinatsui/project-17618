package me.chinatsui.algorithm.exercise.arithmetic;

public class FloatingPointNumberRound {

    public int round(double num) {
        if (num < 0) {
            throw new UnsupportedOperationException();
        }

        int firstDecimalNum = (int) (num * 10) % 10;
        return firstDecimalNum < 5 ? (int) num : (int) num + 1;
    }
}
