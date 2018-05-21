package me.chinatsui.research.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.*;

public class AsyncEchoServer {

    private final int port;
    private AsynchronousServerSocketChannel assc;

    public static void main(String[] args) throws InterruptedException {
        AsyncEchoServer server = new AsyncEchoServer(8080);
        server.start();
        // Below is used to simulate a real server process.
        new CountDownLatch(1).await();
    }

    public AsyncEchoServer(int port) {
        this.port = port;
        try {
            // bind and listen on the port.
            assc = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void start() {
        System.out.println("Started on " + port);
        assc.accept(null, new AcceptCompletionHandler(assc));
        System.out.println("Can do something else.");
    }

    static class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {

        private AsynchronousServerSocketChannel assc;

        public AcceptCompletionHandler(AsynchronousServerSocketChannel assc) {
            this.assc = assc;
        }

        @Override
        public void completed(AsynchronousSocketChannel result, Object attachment) {
            System.out.println(Thread.currentThread().getName());
            Future<Integer> writeResult = null;

            try {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                result.read(buffer).get(100, TimeUnit.SECONDS);

                System.out.println("In server: " + new String(buffer.array()));

                //write data back to client
                buffer.flip();
                writeResult = result.write(buffer);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            } finally {
                // handle next request
                assc.accept(null, this);
                try {
                    writeResult.get();
                    result.close();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            exc.printStackTrace();
        }

    }

}

