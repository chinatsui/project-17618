package me.chinatsui.java.concurrency;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

/**
 * A sample of making use of Java native BlockingQueue to simulate producer and consumer.
 * <p>
 * The FileCrawler scan each file under the specified root directory, and put qualified file into the queue.
 * On the contrary, the FileIndexer takes the file from the queue to do indexing.
 */
public class FileCrawlAndIndex {

    private static final int BOUND = 10;
    private static final int N_CONSUMERS = 3;

    public static void main(String[] args) {
        BlockingQueue<File> fileQueue = new ArrayBlockingQueue<>(BOUND);
        FileFilter fileFilter = pathname -> pathname.isDirectory() ? true : pathname.getName().trim().endsWith("java");
        File[] roots = {
                new File("/home/yaohua/Projects/project-17618/algorithm"),
                new File("/home/yaohua/Projects/project-17618/flash"),
                new File("/home/yaohua/Projects/project-17618/java")
        };

        for (File root : roots) {
            new Thread(new FileCrawler(fileQueue, fileFilter, root)).start();
        }

        for (int i = 0; i < N_CONSUMERS; i++) {
            new Thread(new FileIndexer(fileQueue)).start();
        }
    }

    static class FileCrawler implements Runnable {
        private final BlockingQueue<File> fileQueue;
        private final FileFilter fileFilter;
        private final File root;

        public FileCrawler(BlockingQueue<File> fileQueue,
                           FileFilter fileFilter,
                           File root) {
            this.fileQueue = fileQueue;
            this.fileFilter = fileFilter;
            this.root = root;
        }

        @Override
        public void run() {
            try {
                crawl(root);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void crawl(File file) throws InterruptedException {
            File[] entries = file.listFiles(fileFilter);
            if (entries != null) {
                for (File entry : entries) {
                    if (entry.isDirectory()) {
                        crawl(entry);
                    } else {
                        sleep(300);
                        fileQueue.put(entry);
                        System.out.println(
                                String.format(
                                        "[Producer%s]: Scanned file - %s",
                                        Thread.currentThread().getName(),
                                        entry.getName())
                        );
                    }
                }
            }
        }
    }

    static class FileIndexer implements Runnable {
        private final BlockingQueue<File> fileQueue;

        public FileIndexer(BlockingQueue<File> fileQueue) {
            this.fileQueue = fileQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    File file = fileQueue.take();
                    index(file);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        private void index(File file) {
            sleep(300);
            System.out.println(
                    String.format(
                            "[Consumer%s]: Indexed file - %s",
                            Thread.currentThread().getName(),
                            file.getName())
            );
        }
    }
}
