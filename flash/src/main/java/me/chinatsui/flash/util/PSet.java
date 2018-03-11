package me.chinatsui.flash.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PSet<T> implements Iterable<T> {

    private final Set<T> v;

    public static <T> PSet<T> of(T t) {
        return PSet.<T>empty().plus(t);
    }

    public static <T> PSet<T> of(PSet<T> p) {
        return PSet.<T>empty().plus(p);
    }

    public static <T> PSet<T> empty() {
        return wrap(new HashSet<>());
    }

    public PSet<T> plus(T t) {
        v.add(t);
        return this;
    }

    public PSet<T> plus(T... elements) {
        v.addAll(Arrays.asList(elements));
        return this;
    }

    public PSet<T> plus(PSet<T> p) {
        v.addAll(p.v);
        return this;
    }

    public PSet<T> minus(T t) {
        v.remove(t);
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

    public boolean isEmpty() {
        return v.size() == 0;
    }

    public boolean contains(T t) {
        return v.contains(t);
    }

    public PSet<T> intersect(PSet<T> others) {
        PSet<T> intersection = PSet.empty();
        for (T t : others) {
            if (this.contains(t)) {
                intersection.plus(t);
            }
        }
        return intersection;
    }

    public int size() {
        return v.size();
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
