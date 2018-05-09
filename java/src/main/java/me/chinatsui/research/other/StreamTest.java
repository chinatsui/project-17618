package me.chinatsui.research.other;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    private List<Integer> data = new ArrayList();

    @Before
    public void setup() {
        data.add(100);
        data.add(200);
        data.add(300);
    }

    @Test
    public void test_any_match() {
        Assert.assertTrue(data.stream().anyMatch(i -> i == 100));
    }

    @Test
    public void test_forEach() {
        data.stream().forEach(i -> System.out.println(i));
    }

    @Test
    public void test_filter() {
        data = data.stream().filter(i-> i != 100).collect(Collectors.toList());
        Assert.assertEquals(2, data.size());
    }

    @Test
    public void test_array_convert_to_map_val_is_key_index_is_value() {
        int[] arr = {1, 2, 3, 4, 5};
    }

}
