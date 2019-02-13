package me.chinatsui.java.concurrency;

import me.chinatsui.java.commons.RandomUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static me.chinatsui.java.commons.ThreadUtils.sleep;

public class PageRender {

    private final ExecutorService executor;

    public PageRender(ExecutorService executor) {
        this.executor = executor;
    }

    public static void main(String[] args) {
        PageRender instance = new PageRender(Executors.newFixedThreadPool(5));
        instance.render();
    }

    public void render() {
        List<ImageInfo> infoList = scanForImageInfo();
        CompletionService completionService = new ExecutorCompletionService(executor);
        for (ImageInfo info : infoList) {
            completionService.submit(() -> info.download());
        }

        renderText();

        try {
            for (int i = 0; i < infoList.size(); i++) {
                Future<ImageData> f = completionService.take();
                ImageData data = f.get();
                renderImage(data);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            e.getCause().printStackTrace();
        }

        done();
    }

    public void done() {
        this.executor.shutdown();
    }

    private void renderText() {
        System.out.println("Rendered text: " + RandomUtils.getRandomString(50));
    }

    private void renderImage(ImageData imageData) {
        System.out.println("Rendered image data: " + imageData.getData());
    }

    private List<ImageInfo> scanForImageInfo() {
        return Arrays.asList(new ImageInfo(), new ImageInfo(), new ImageInfo(), new ImageInfo());
    }

    class ImageInfo {

        public ImageData download() {
            sleep(RandomUtils.getRandomInt(300, 3000));
            return new ImageData(RandomUtils.getRandomString(10));
        }
    }

    class ImageData {

        private String data;

        public ImageData(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }
}


