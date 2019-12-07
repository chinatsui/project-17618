package me.chinatsui.algorithm.exercise.arithmetic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sqrt {

    public double calculate(double target, double precision) {
        if (target == 0) {
            return 0;
        }

        double lo = 0, hi = target >= 1 ? target : 1;

        if (precision >= 1) {
            precision = 1;
        }

        while (lo <= hi) {
            double mi = lo + (hi - lo) / 2;
            if (mi > target / mi) {
                hi = mi;
            } else {
                if (mi + precision > target / (mi + precision)) {
                    return round(mi, precision);
                } else {
                    lo = mi;
                }
            }
        }

        return Double.NaN;
    }

    private double round(double num, double precision) {
        int scale = 0;
        while (precision < 1) {
            scale++;
            precision *= 10;
        }
        return new BigDecimal(num).setScale(scale, RoundingMode.UP).doubleValue();
    }
}
