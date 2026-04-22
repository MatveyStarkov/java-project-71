package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    public static String getPath(String fileName) {

        String filePath = "./src/test/resources/fixtures/" + fileName;

        String normPath = Path.of(filePath).toAbsolutePath().normalize().toString();
        return normPath;
    }

    @Test
    void testGenerateJSON() throws IOException {

        String file1 = getPath("file1.json");
        String file2 = getPath("file2.json");

        String res = Differ.generate(file1, file2);

        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

        assertEquals(expected, res);
    }

    @Test
    void testGenerateEmptyJSON() throws IOException {

        String file1 = getPath("file1.json");
        String file2 = getPath("empty.json");

        String res = Differ.generate(file1, file2);

        String expected = """
                {
                  - follow: false
                  - host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                }""";

        assertEquals(expected, res);
    }

    @Test
    void testGenerateYAML() throws IOException {
        String file1 = getPath("file1.yaml");
        String file2 = getPath("file2.yaml");
        String actual = Differ.generate(file1, file2);

        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertEquals(actual, expected);
    }
}
