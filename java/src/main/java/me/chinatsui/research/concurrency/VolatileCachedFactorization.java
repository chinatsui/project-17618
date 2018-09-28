package me.chinatsui.research.concurrency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VolatileCachedFactorization {

    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.valueOf(2);

    private volatile LastOneCache cache = new LastOneCache(null, null);

    public BigInteger[] getFactors(BigInteger i) {
        BigInteger[] factors = cache.getFactors(i);

        if (factors == null) {
            factors = factor(i);
            cache = new LastOneCache(i, factors);
        }

        return factors;
    }

    private BigInteger[] factor(BigInteger i) {
        List<BigInteger> results = new ArrayList<>();

//        while (!i.equals(ONE)) {
//            for (BigInteger factor = TWO; true; factor = factor.add(ONE)) {
//                if (i.mod(factor).equals(ZERO)) {
//                    results.add(factor);
//                    i = i.divide(factor);
//                    break;
//                }
//            }
//        }

        for (BigInteger f = TWO; f.compareTo(i) <= 0; f = f.add(ONE)) {
            if (i.mod(f).equals(ZERO)) {
                results.add(f);
                i = i.divide(f);
                f = f.subtract(ONE);
            }
        }

        return results.toArray(new BigInteger[0]);
    }

    static class LastOneCache {
        private final BigInteger lastNumber;
        private final BigInteger[] factors;

        public LastOneCache(BigInteger lastOne, BigInteger[] factors) {
            this.lastNumber = lastOne;
            this.factors = factors != null ? Arrays.copyOf(factors, factors.length) : null;
        }

        public BigInteger[] getFactors(BigInteger i) {
            if (lastNumber == null || !lastNumber.equals(i)) {
                return null;
            }

            return Arrays.copyOf(factors, factors.length);
        }
    }
}
