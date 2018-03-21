package me.chinatsui.research.concurrency;

import java.math.BigInteger;
import java.util.Arrays;

public class VolatileCachedFactorizer {

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
        return null;
    }

    static class LastOneCache {

        private final BigInteger lastNumber;
        private final BigInteger[] factors;

        public LastOneCache(BigInteger lastOne, BigInteger[] factors) {
            this.lastNumber = lastOne;
            this.factors = Arrays.copyOf(factors, factors.length);
        }

        public BigInteger[] getFactors(BigInteger i) {
            if (lastNumber == null || !lastNumber.equals(i)) {
                return null;
            }

            return Arrays.copyOf(factors, factors.length);
        }
    }

}
