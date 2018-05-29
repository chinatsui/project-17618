package me.chinatsui.research.other;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

public class MapTest {

    @Test
    public void test_tree_map_only_with_value_comparator_ignore_entry_with_same_value_on_different_key() {
        HashMap hMap = new HashMap();
        hMap.put(5, 2);
        hMap.put(4, 1);
        hMap.put(2, 2);
        hMap.put(3, 4);

        TreeMap tMap = new TreeMap(new ValueComparator(hMap));
        tMap.putAll(hMap);
        System.out.println(tMap);
        Assert.assertEquals(3, tMap.size());
    }

    @Test
    public void test_tree_map_with_value_comparator_then_comparing_natural_order() {
        HashMap hMap = new HashMap();
        hMap.put(5, 2);
        hMap.put(4, 1);
        hMap.put(2, 2);
        hMap.put(3, 4);

        TreeMap tMap = new TreeMap(new ValueComparator(hMap).thenComparing(Comparator.naturalOrder()));
        tMap.putAll(hMap);
        System.out.println(tMap);
    }

    @Test
    public void test_hash_map_sorted_by_value() {
        HashMap hMap = new HashMap();
        hMap.put(4, 1);
        hMap.put(1, 2);
        hMap.put(2, 2);
        hMap.put(3, 4);

        LinkedList<Map.Entry<Integer, Integer>> list = new LinkedList<>(hMap.entrySet());
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));

        LinkedHashMap lMap = new LinkedHashMap();
        list.forEach(e -> lMap.put(e.getKey(), e.getValue()));
        System.out.println(lMap);
        Assert.assertEquals(4, lMap.size());
    }

    class ValueComparator implements Comparator {

        private Map map;

        public ValueComparator(Map map) {
            this.map = map;
        }

        @Override
        public int compare(Object o1, Object o2) {
            Comparable v1 = (Comparable) map.get(o1);
            Comparable v2 = (Comparable) map.get(o2);
            return v1.compareTo(v2);
        }

    }

}
