package me.chinatsui.research.other;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
    public void test_distinct_list_to_linked_hash_set_in_order() {
        List<String> nums = new ArrayList<>();
        nums.add("ABC");
        nums.add("ABCD");
        nums.add("ABCD");
        nums.add("BCDEF");
        nums.add("BCDEF");
        nums.add("BCDEF");
        nums.add("XYZ");
        nums.add("XYZ");
        nums.add("XYZ");
        Set<String> set = nums.stream().distinct().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(set);
    }

}
