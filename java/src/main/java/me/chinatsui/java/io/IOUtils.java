package me.chinatsui.java.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IOUtils {

    private IOUtils() {
    }

    public static void readFile(String src) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(src))) {
            lines.forEach(System.out::println);
        }
    }

    public static void fastCopy(String src, String dist) throws IOException {

        try ( FileInputStream fis = new FileInputStream(src);
              FileOutputStream fos = new FileOutputStream(dist)) {
                FileChannel fcin = fis.getChannel();
                FileChannel fcout = fos.getChannel();
                ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

                while (true) {
        
                    /* 从输入通道中读取数据到缓冲区中 */
                    int r = fcin.read(buffer);
        
                    /* read() 返回 -1 表示 EOF */
                    if (r == -1) {
                        break;
                    }
        
                    /* 切换读写, limit置为position，position置为0 */
                    buffer.flip();
        
                    /* 把缓冲区的内容写入输出文件中 */
                    fcout.write(buffer);
        
                    /* 清空缓冲区 */
                    buffer.clear();
                }
        }

    }
}
