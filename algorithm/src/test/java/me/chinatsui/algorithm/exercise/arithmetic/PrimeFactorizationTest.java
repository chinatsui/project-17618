package me.chinatsui.algorithm.exercise.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class PrimeFactorizationTest {

    PrimeFactorization pf = new PrimeFactorization();

    @Test(expected = IllegalArgumentException.class)
    public void test_getPrimeFactors_when_given_non_positive_number_throws_illegal_argument_exception() {
        pf.getPrimeFactors(0);
        pf.getPrimeFactors(-1);
        pf.getPrimeFactors(-10);
        pf.getPrimeFactors(-255);
    }

    @Test
    public void test_getPrimeFactors_when_given_zero_returns_empty_factors() {
        Assert.assertArrayEquals(new int[0], pf.getPrimeFactors(1));
    }

    @Test
    public void test_getPrimeFactors_when_given_prime_number_returns_empty_factors() {
        Assert.assertArrayEquals(new int[]{13}, pf.getPrimeFactors(13));
    }

    @Test
    public void test_getPrimeFactors_when_given_composite_number_returns_expected_factors() {
        Assert.assertArrayEquals(new int[]{2, 2, 3, 3, 5}, pf.getPrimeFactors(180));
    }
}
