package me.chinatsui.algorithm.review.stack;

import java.util.Iterator;

public abstract class AbstractStack<T> implements Stack<T> {

    abstract Iterator<T> iterator();

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuffer buffer = new StringBuffer("[");
        Iterator itr = iterator();
        while (itr.hasNext()) {
            buffer.append(itr.next());

            if (itr.hasNext()) {
                buffer.append(", ");
            } else {
                buffer.append("]");
            }
        }
        return buffer.toString();
    }

}
