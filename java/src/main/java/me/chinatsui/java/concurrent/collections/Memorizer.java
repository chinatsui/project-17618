package me.chinatsui.java.concurrent.collections;

import me.chinatsui.java.commons.RandomUtils;

import java.util.Map;
import java.util.concurrent.*;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

/**
 * An sample of efficient and scalable cache memorizer.
 *
 * @param <A> input
 * @param <V> output
 */
public class Memorizer<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache;
    private final Computable<A, V> computable;

    private Memorizer(Computable<A, V> computable) {
        cache = new ConcurrentHashMap<>();
        this.computable = computable;
    }

    public static void main(String[] args) {
        Computable<Integer, Integer> eval = arg -> {
            sleep(RandomUtils.getRandomInt(300, 600));
            return arg * arg;
        };

        Memorizer<Integer, Integer> memorizer = new Memorizer<>(eval);
        memorizer.compute(12);
        memorizer.compute(12);
    }

    @Override
    public V compute(A arg) {
        while (true) {
            Future<V> future = cache.get(arg);
            if (future == null) {
                FutureTask<V> ft = new FutureTask<>(() -> computable.compute(arg));

                /*
                  cache.put(arg, ft) cannot avoid duplicate FutureTask run
                  when two or more threads reach here simultaneously.
                 */
                future = cache.putIfAbsent(arg, ft);

                /*
                  1. If null, then this is the first thread reaches here, then just run it.
                  2. If not null, then it means there must be another thread reaches here before,
                  and it has already invoked ft.run(), so just go to future.get() to get result.
                 */
                if (future == null) {
                    future = ft;
                    ft.run();
                }
            }

            try {
                return future.get();
            } catch (CancellationException e) {
                /*
                  Used for avoid cache pollution.
                  If a computing process is cancelled, then cache just stored a cancelled future.
                  We should remove it from cache.
                 */
                cache.remove(arg);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

interface Computable<A, V> {

    V compute(A arg);

}
