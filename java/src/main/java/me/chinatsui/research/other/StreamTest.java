package me.chinatsui.research.other;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
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
        List<Text> list = new ArrayList<>();
        list.add(new Text("ABC"));
        list.add(new Text("ABC"));
        list.add(new Text("ABC"));
        list.add(new Text("DEF"));

        Set<Text> set = list.stream().distinct().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(set);
    }

    public static class Text {

        private String str;

        public Text(String str) {
            this.str = str;
        }

        public String toString() {
            return str;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Text text = (Text) o;
            return Objects.equals(str, text.str);
        }

        @Override
        public int hashCode() {
            return Objects.hash(str);
        }
    }

}
