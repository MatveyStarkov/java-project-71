package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Formatter {
    public static String getFormat(List<Map<String, Object>> difference, String formatName) throws IOException {
        return switch (formatName) {
            case "stylish" -> Stylish.format(difference);
            case "plain" -> Plain.format(difference);
            case "json" -> Json.format(difference);
            default -> throw new RuntimeException("Unexpected format: " + formatName);
        };
    }
}
