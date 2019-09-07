package me.chinatsui.algorithm.exercise.bit;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.algorithm.exercise.bit.BitMap;

public class BitMapTest {

    @Test
    public void test_only_number_between_0_and_max_bits_could_not_be_set() {
        BitMap bitMap = new BitMap(1024);

        bitMap.set(-1);
        Assert.assertFalse(bitMap.exists(-1));

        bitMap.set(1025);
        Assert.assertFalse(bitMap.exists(1025));

        bitMap.set(101);
        Assert.assertTrue(bitMap.exists(101));

        bitMap.set(102);
        Assert.assertTrue(bitMap.exists(102));

        bitMap.set(103);
        Assert.assertTrue(bitMap.exists(103));
    }
}
