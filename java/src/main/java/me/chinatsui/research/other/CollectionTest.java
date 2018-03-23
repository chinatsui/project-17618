package me.chinatsui.research.other;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public enum CollectionTest {

    INSTANCE;

    public int[] integerToInt(Collection<Integer> collection) {
        return collection.stream().mapToInt(i -> i).toArray();
    }

}
