package me.chinatsui.research.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AsyncEchoClient {

    public static void main2(String[] args) throws IOException {

        final AsynchronousSocketChannel client = AsynchronousSocketChannel.open();

        InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 8001);

        // connect and register completion handler.
        client.connect(serverAddress, null, new CompletionHandler<Void, Object>() {

            @Override
            public void completed(Void result, Object attachment) {
                // write data and register completion handler.
                client.write(ByteBuffer.wrap("Thank you!".getBytes()), null, new CompletionHandler<Integer, Object>() {

                    @Override
                    public void completed(Integer result,
                                          Object attachment) {
                        final ByteBuffer buffer = ByteBuffer.allocate(1024);
                        // read data and register completion handler.
                        client.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {

                            @Override
                            public void completed(Integer result,
                                                  ByteBuffer attachment) {
                                buffer.flip();
                                System.out.println("In Client: " + new String(buffer.array()));
                                try {
                                    client.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void failed(Throwable exc, ByteBuffer attachment) {
                                exc.printStackTrace();
                            }

                        });
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        exc.printStackTrace();
                    }

                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }

        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
