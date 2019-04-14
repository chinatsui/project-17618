package me.chinatsui.algorithm.core.sort;

import org.junit.Assert;

public abstract class AbstractSortTest {

    protected void verifySorted(int[] data) {
        if (data == null) {
            return;
        }

        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(data[i] <= data[i + 1]);
        }
    }
}
