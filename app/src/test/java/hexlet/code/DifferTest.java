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
    void testGenerateStylishFormat() throws IOException {
        String file1 = getPath("file1.json");
        String file2 = getPath("file2.json");

        String res = Differ.generate(file1, file2, "stylish");

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
    void testGeneratePlainFormat() throws IOException {
        String file1 = getPath("file3.json");
        String file2 = getPath("file4.json");

        String res = Differ.generate(file1, file2, "plain");

        String expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";

        assertEquals(expected, res);
    }

}
