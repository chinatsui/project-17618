package me.chinatsui.algorithm.exercise.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class ShipPackagesTest {

    private ShipPackages sp = new ShipPackages();

    @Test
    public void test() {
        Assert.assertEquals(15, sp.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
        Assert.assertEquals(6, sp.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        Assert.assertEquals(3, sp.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }
}
