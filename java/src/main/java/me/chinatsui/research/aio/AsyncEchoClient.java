package me.chinatsui.research.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AsyncEchoClient {

    private String host;
    private int port;
    private AsynchronousSocketChannel asc;

    public static void main(String[] args) throws InterruptedException {
        AsyncEchoClient client = new AsyncEchoClient("127.0.0.1", 8080);

        client.connect(new InetSocketAddress(client.host, client.port));
        client.send("Hello");
    }

    public AsyncEchoClient(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            this.asc = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void connect(InetSocketAddress address) {
        asc.connect(address, null, new ConnectCompleteHandler(asc));
    }

    public void send(String message) {
        asc.write(ByteBuffer.wrap(message.getBytes()), null, new WriteCompletionHandler(asc));
    }

    static class ConnectCompleteHandler implements CompletionHandler<Void, Object> {

        private AsynchronousSocketChannel asc;

        public ConnectCompleteHandler(AsynchronousSocketChannel asc) {
            this.asc = asc;
        }

        @Override
        public void completed(Void result, Object attachment) {
            System.out.println("Connection established...");
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            exc.printStackTrace();
        }

    }

    static class WriteCompletionHandler implements CompletionHandler<Integer, Object> {

        private AsynchronousSocketChannel asc;

        public WriteCompletionHandler(AsynchronousSocketChannel asc) {
            this.asc = asc;
        }

        @Override
        public void completed(Integer result, Object attachment) {
            System.out.println("After write completion...");
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            asc.read(buffer, buffer, new ReadCompletionHandler(asc));
            System.out.println(new String(buffer.array()));
        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            exc.printStackTrace();
        }
    }

    static class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

        private AsynchronousSocketChannel asc;

        public ReadCompletionHandler(AsynchronousSocketChannel asc) {
            this.asc = asc;
        }

        @Override
        public void completed(Integer result, ByteBuffer attachment) {
            System.out.println(new String(attachment.array()));
            System.out.println("After read completion...");
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            exc.printStackTrace();
        }

    }

}
