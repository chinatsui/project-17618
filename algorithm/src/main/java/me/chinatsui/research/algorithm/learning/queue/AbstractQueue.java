package me.chinatsui.research.algorithm.learning.queue;

import java.util.Iterator;

public abstract class AbstractQueue<T> implements Queue<T> {

    abstract Iterator<T> iterator();

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        Iterator<T> iterator = iterator();

        StringBuffer buffer = new StringBuffer("[");

        while(iterator.hasNext()) {

            buffer.append(iterator.next());

            if (iterator.hasNext()) {
                buffer.append(", ");
            } else {
                buffer.append("]");
            }
        }
        return buffer.toString();
    }

}
