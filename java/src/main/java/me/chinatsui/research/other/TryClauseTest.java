package me.chinatsui.research.other;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;

public class TryClauseTest {

    @Test
    public void test_how_try_clause_work() {
        try {
            URI uri = this.getClass().getClassLoader().getResource("abc.txt").toURI();
            Path path = Paths.get(uri);

            try {
                Stream stream = Files.lines(path);
                Throwable var = null;

                try {
                    System.out.println(1);
                    throw new RuntimeException("#1");
                } catch (Throwable t) {
                    var = t;
                    throw t;
                } finally {
                    if (stream != null) {
                        try {
                            stream.close();
                            throw new RuntimeException("#2");
                        } catch (Throwable t) {
                            if (var != null) {
                                var.addSuppressed(t);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("#3");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
