package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }


    @BeforeAll
    public static void beforeAll() throws Exception {
        resultJson = readFixture("result_json.json");
        resultPlain = readFixture("result_plain.txt");
        resultStylish = readFixture("result_stylish.txt");
    }

    public static String getPath(String fileName) {

        String filePath = "./src/test/resources/fixtures/" + fileName;

        String normPath = Path.of(filePath).toAbsolutePath().normalize().toString();
        return normPath;
    }

    @Test
    void testGenerateDefaultJSON() throws IOException {

        String file1 = getPath("file3.json");
        String file2 = getPath("file4.json");

        String res = Differ.generate(file1, file2);

        String expected = resultStylish;

        assertEquals(expected, res);
    }

    @Test
    void testGenerateDefaultYAML() throws IOException {
        String file1 = getPath("file1.yaml");
        String file2 = getPath("file2.yaml");
        String res = Differ.generate(file1, file2);

        String expected = resultStylish;
        assertEquals(expected, res);
    }

    @Test
    void testGenerateStylishFormat() throws IOException {
        String file1 = getPath("file3.json");
        String file2 = getPath("file4.json");

        String res = Differ.generate(file1, file2, "stylish");

        String expected = resultStylish;

        assertEquals(expected, res);
    }

    @Test
    void testGeneratePlainFormat() throws IOException {
        String file1 = getPath("file3.json");
        String file2 = getPath("file4.json");

        String res = Differ.generate(file1, file2, "plain");

        String expected = resultPlain;

        assertEquals(expected, res);
    }

    @Test
    void testGenerateYamlToPlainFormat() throws IOException {
        String file1 = getPath("file1.yaml");
        String file2 = getPath("file2.yaml");

        String res = Differ.generate(file1, file2, "plain");

        String expected = resultPlain;

        assertEquals(expected, res);
    }

    @Test
    void testGenerateYamlToStylishFormat() throws IOException {
        String file1 = getPath("file1.yaml");
        String file2 = getPath("file2.yaml");

        String res = Differ.generate(file1, file2, "stylish");

        String expected = resultStylish;

        assertEquals(expected, res);
    }



    @Test
    void testGenerateJsonFormat() throws IOException {
        String file1 = getPath("file3.json");
        String file2 = getPath("file4.json");

        String actual = Differ.generate(file1, file2, "json");
        String expected = resultJson;

        assertEquals(expected, actual);
    }

    @Test
    void testGenerateYamlToJsonFormat() throws IOException {
        String file1 = getPath("file1.yaml");
        String file2 = getPath("file2.yaml");

        String actual = Differ.generate(file1, file2, "json");
        String expected = resultJson;

        assertEquals(expected, actual);
    }

}
