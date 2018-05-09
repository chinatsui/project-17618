package me.chinatsui.research.other;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

public class ArrayListTest {

    @Test
    public void test_retainAll_returns_intersection_of_two_lists() {
        ArrayList<Integer> list_1 = new ArrayList(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        ArrayList<Integer> list_2 = new ArrayList(Arrays.asList(1, 2, 3, 4, 50, 60, 70, 80, 90));
        list_1.retainAll(list_2);
        Assert.assertEquals(3, list_1.size());
        Assert.assertEquals(50, list_1.get(0).longValue());
        Assert.assertEquals(60, list_1.get(1).longValue());
        Assert.assertEquals(70, list_1.get(2).longValue());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void test_for_each_remove_item_throw_exception() {
        ArrayList<Integer> list = new ArrayList(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        list.forEach(e -> {
            if (e == 30) {
                list.remove(e);
            }
        });
    }

}
