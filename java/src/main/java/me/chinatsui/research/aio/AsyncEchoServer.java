package me.chinatsui.research.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.*;

public class AsyncEchoServer {

    public final static int PORT = 8001;
    public final static String IP = "127.0.0.1";


    private AsynchronousServerSocketChannel server = null;

    public static void main(String[] args) throws InterruptedException {
        new AsyncEchoServer().start();
        new CountDownLatch(1).await();
    }

    public void start() {

        try {
            server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(IP, PORT));
            System.out.println("Server listen on " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // register accept completion handler
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

            final ByteBuffer buffer = ByteBuffer.allocate(1024);

            @Override
            public void completed(AsynchronousSocketChannel socketChannel, Object attachment) {

                System.out.println(Thread.currentThread().getName());
                Future<Integer> toClient = null;

                try {
                    buffer.clear();
                    socketChannel.read(buffer).get(100, TimeUnit.SECONDS);

                    System.out.println("In server: " + new String(buffer.array()));

                    // write data back to client
                    toClient = socketChannel.write(ByteBuffer.wrap("Welcome!".getBytes()));
                } catch (InterruptedException | ExecutionException | TimeoutException e) {
                    e.printStackTrace();
                } finally {
                    server.accept(null, this);
                    try {
                        toClient.get();
                        // balabala..
                        socketChannel.close();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("failed:" + exc);
            }

        });

        System.out.println("Something else.");
    }

}

