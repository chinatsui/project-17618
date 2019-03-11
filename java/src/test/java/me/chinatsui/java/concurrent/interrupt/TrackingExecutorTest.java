package me.chinatsui.java.concurrent.interrupt;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import me.chinatsui.java.commons.RandomUtils;

public class TrackingExecutorTest {

    @Test
    public void test_tracking_executor_works_as_expected() throws InterruptedException {
        Set<String> seedUrls = new HashSet<>();
        for (int i = 0; i < 800; i++) {
            seedUrls.add("https://" + RandomUtils.getRandomString(10));
        }
        PageCrawler crawler = new PageCrawler(seedUrls);
        crawler.start();
        sleep(3000);
        crawler.stop(100);
//        Assert.assertTrue(crawler.urlsNotCrawled.size() > 0);
        System.out.println(crawler.urlsCancelCrawled.size());
        Assert.assertTrue(crawler.urlsCancelCrawled.size() > 0);

    }

    class PageCrawler {
        private volatile TrackingExecutor exec;
        private final Set<String> urlsToCrawl = new HashSet<>();
        private final Set<String> urlsNotCrawled = new HashSet<>();
        private final Set<String> urlsCancelCrawled = new HashSet<>();

        public PageCrawler(Set<String> seedUrls) {
            urlsToCrawl.addAll(seedUrls);
        }

        public synchronized void start() {
            exec = new TrackingExecutor();
            urlsToCrawl.addAll(urlsNotCrawled);
            urlsToCrawl.addAll(urlsCancelCrawled);
            for (String url : urlsToCrawl) {
                submitCrawlTask(url);
            }
            urlsNotCrawled.clear();
            urlsCancelCrawled.clear();
            urlsToCrawl.clear();
        }

        public synchronized void stop(long timeout) throws InterruptedException {
            try {
                saveNotCrawled(exec.shutdownNow());
                if (exec.awaitTermination(timeout, TimeUnit.MILLISECONDS)) {
                    saveCancelCrawled(exec.getCancelledTasks());
                }
            } finally {
                exec = null;
            }
        }

        private void submitCrawlTask(String url) {
            if (exec.isShutdown()) {
                return;
            }
            exec.execute(new CrawlTask(url));
        }

        private void saveNotCrawled(List<Runnable> tasks) {
            for (Runnable task : tasks) {
                urlsNotCrawled.add(((CrawlTask) task).url);
            }
        }

        private void saveCancelCrawled(List<Runnable> tasks) {
            for (Runnable task : tasks) {
                urlsCancelCrawled.add(((CrawlTask) task).url);
            }
        }

        private class CrawlTask implements Runnable {
            private String url;

            private CrawlTask(String url) {
                this.url = url;
            }

            @Override
            public void run() {
                for (String derived : processPage(url)) {
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                    submitCrawlTask(derived);
                }
            }

            private List<String> processPage(String url) {
                sleep(url.length() + RandomUtils.getRandomInt(500, 1000));
                List<String> derived = new ArrayList<>();
                int j = RandomUtils.getRandomInt(0, 2);
                for (int i = 0; i < j; i++) {
                    derived.add("https://" + RandomUtils.getRandomString(10));
                }
                return derived;
            }
        }
    }
}
