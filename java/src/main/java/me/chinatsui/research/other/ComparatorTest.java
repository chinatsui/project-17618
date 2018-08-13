package me.chinatsui.research.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ComparatorTest {

    @Test(expected = NullPointerException.class)
    public void test_sort_collection_which_has_null_element_throws_NPE() {
        List<String> list = new ArrayList();
        list.add("B");
        list.add("C");
        list.add(null);
        list.add("A");
        list.add(null);
        Collections.sort(list);
    }

    @Test
    public void test_sort_collection_which_has_null_element_by_defined_rule() {
        List<String> list = new ArrayList();
        list.add("B");
        list.add("C");
        list.add(null);
        list.add("A");
        list.add(null);
        Collections.sort(list, (o1, o2) -> {
            if (o1 == null) {
                return -1;
            }

            if (o2 == null) {
                return 1;
            }

            return o1.compareTo(o2);
        });
        Assert.assertNull(list.get(0));
        Assert.assertNull(list.get(1));
        Assert.assertEquals("A", list.get(2));
        Assert.assertEquals("B", list.get(3));
        Assert.assertEquals("C", list.get(4));
    }

}
