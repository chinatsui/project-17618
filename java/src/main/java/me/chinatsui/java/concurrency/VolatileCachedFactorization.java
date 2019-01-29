package me.chinatsui.java.concurrency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * The key point is "Copy", it can guarantee the value inside would not be changed.
 */
public class VolatileCachedFactorization {

    private static final VolatileCachedFactorization instance = new VolatileCachedFactorization();
    private volatile LastOneCache cache = new LastOneCache(null, null);

    private VolatileCachedFactorization() {
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture future1 = CompletableFuture.supplyAsync(() -> instance.getFactors(BigInteger.valueOf(12)));
        CompletableFuture future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000L);
                return instance.getFactors(BigInteger.valueOf(24));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        BigInteger[] arr1 = (BigInteger[]) future1.get();
        BigInteger[] arr2 = (BigInteger[]) future2.get();
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

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

        BigInteger factor = BigInteger.valueOf(2);
        while (!i.equals(BigInteger.ONE)) {
            BigInteger[] factors = cache.getFactors(i);

            // cache found, so return factors + cache as result
            if (factors != null) {
                BigInteger[] arr1 = results.toArray(new BigInteger[0]);
                BigInteger[] arr2 = factors;
                BigInteger[] res = new BigInteger[arr1.length + arr2.length];
                System.arraycopy(arr1, 0, res, 0, arr1.length);
                System.arraycopy(arr2, 0, res, arr1.length, arr2.length);
                return res;
            }

            // cache not found, proceed.
            if (i.mod(factor).equals(BigInteger.ZERO)) {
                results.add(factor);
                i = i.divide(factor);
            } else {
                factor = factor.add(BigInteger.ONE);
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
