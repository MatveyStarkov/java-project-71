package hexlet.code;

import hexlet.code.formatter.Stylish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String path1, String path2, String format) throws IOException {

        String content1 = readFile(path1);
        String content2 = readFile(path2);

        String fileExtension1 = getFormat(path1);
        String fileExtension2 = getFormat(path2);

        Map<String, Object> parsedData1 = Parser.parse(content1, fileExtension1);
        Map<String, Object> parsedData2 = Parser.parse(content2, fileExtension2);

        List<Map<String, Object>> x = FileComparator.compare(parsedData1, parsedData2);

        return format(x, format);

    }

    public static String generate(String path1, String path2) throws IOException {
        return generate(path1, path2, "stylish");
    }


    public static String readFile(String path) throws IOException {
        Path normPath = Path.of(path).toAbsolutePath().normalize();
        return Files.readString(normPath);
    }

    public static String getFormat(String path) {
        if (path.endsWith("json")) {
            return "json";
        } else if (path.endsWith("yaml")) {
            return "yaml";
        } else if (path.endsWith("yml")) {
            return "yml";
        } else {
            throw new RuntimeException("File '" + path + "' is in an unknown format");
        }
    }

    private static String format(List<Map<String, Object>> diff, String formatName) {
        return switch (formatName) {
            case "stylish" -> Stylish.format(diff);
            default -> throw new IllegalArgumentException("Unsupported output format: " + formatName);
        };
    }


}


