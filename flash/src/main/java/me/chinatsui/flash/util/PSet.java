package me.chinatsui.flash.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PSet<T> implements Iterable<T> {

    private final Set<T> v;

    public static <T> PSet<T> of(T first) {
        return PSet.<T>empty().plus(first);
    }

    public static <T> PSet<T> empty() {
        return wrap(new HashSet<>());
    }

    public PSet<T> plus(T first) {
        v.add(first);
        return this;
    }

    public PSet<T> plus(T... elements) {
        v.addAll(Arrays.asList(elements));
        return this;
    }

    public PSet<T> minus(T first) {
        v.remove(first);
        return this;
    }

    public PSet<T> minus(T... elements) {
        v.removeAll(Arrays.asList(elements));
        return this;
    }

    public PSet<T> minus(PSet<T> p) {
        v.removeAll(p.v);
        return this;
    }

    static <T> PSet<T> wrap(Set<T> set) {
        return new PSet(set);
    }

    private PSet(Set<T> v) {
        this.v = v;
    }

    @Override
    public Iterator<T> iterator() {
        return v.iterator();
    }

}
