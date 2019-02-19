package me.chinatsui.java.concurrent.execution;

import me.chinatsui.java.commons.RandomUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

public class TravelQuotesFetcher {

    private final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        TravelQuotesFetcher fetcher = new TravelQuotesFetcher();
        List<TravelQuote> quotes = fetcher.getTravelQuotes();
        for (TravelQuote quote: quotes) {
            System.out.println(quote.getValue());
        }
        fetcher.executor.shutdown();
    }

    private List<TravelQuote> getTravelQuotes() throws InterruptedException {
        List<TravelQuoteTask> tasks = new ArrayList<>();

        int taskCount = 8;
        for (int i = 1; i <= taskCount; i++) {
            tasks.add(new TravelQuoteTask(i));
        }

        List<Future<TravelQuote>> futures = executor.invokeAll(tasks, 2000, TimeUnit.MILLISECONDS);
        List<TravelQuote> quotes = new ArrayList<>(tasks.size());
        Iterator<TravelQuoteTask> taskItr = tasks.iterator();
        for (Future<TravelQuote> f : futures) {
            TravelQuoteTask task = taskItr.next();
            try {
                quotes.add(f.get());
            } catch (ExecutionException | CancellationException e) {
                System.out.println("Task: " + task.getId() + " is cancelled or failed.");
            }
        }

        return quotes;
    }

    class TravelQuoteTask implements Callable<TravelQuote> {

        private int id;

        TravelQuoteTask(int id) {
            this.id = id;
        }

        @Override
        public TravelQuote call() throws Exception {
            sleep(RandomUtils.getRandomInt(300, 3000));
            return new TravelQuote(String.valueOf(this.id));
        }

        int getId() {
            return id;
        }
    }

    class TravelQuote {
        private String value;

        TravelQuote(String src) {
            this.value = src + ":" + RandomUtils.getRandomString(10);
        }

        String getValue() {
            return value;
        }
    }
}
