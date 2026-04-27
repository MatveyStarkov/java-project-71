package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;


public class Formatter {
    public static String getFormat(List<Map<String, Object>> differenceList, String formatName) {
        return switch (formatName) {
            case "stylish" -> Stylish.format(differenceList);
            case "plain" -> Plain.format(differenceList);
            default -> throw new RuntimeException("Unexpected format: " + formatName);
        };
    }
}
