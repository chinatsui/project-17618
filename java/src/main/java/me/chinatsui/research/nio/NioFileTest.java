package me.chinatsui.research.nio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;


public class NioFileTest {

    @Test
    public void test_read_lines() {
        try {
            URI location = NioFileTest.class.getClassLoader().getSystemResource("abc.txt").toURI();

            try (Stream<String> stream = Files.lines(Paths.get(location))) {
                stream.forEach(line -> System.out.println(line));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
