package me.chinatsui.research.concurrency;

import org.junit.Assert;
import org.junit.Test;

public class ThreadLocalTest {

    @Test
    public void test_thread_local_holder_holds_different_object_for_each_thread() {
        Object var = new Object();
        ThreadLocalHolder holder = new ThreadLocalHolder();
        holder.set(var);

        new Thread(() -> Assert.assertFalse(var.hashCode() == holder.get().hashCode())).start();
        new Thread(() -> Assert.assertFalse(var.hashCode() == holder.get().hashCode())).start();
    }

    public static class ThreadLocalHolder {
        private static final ThreadLocal<Object> holder = ThreadLocal.withInitial(() -> new Object());

        public void set(Object obj) {
            holder.set(obj);
        }

        public Object get() {
            return holder.get();
        }
    }

}
