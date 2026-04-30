package hexlet.code.formatters;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> x) throws IOException {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> compareRes : x) {
            Object value1 = compareRes.get("value1");
            Object value2 = compareRes.get("value2");
            Object key = compareRes.get("key");
            switch (String.valueOf(compareRes.get("status"))) {
                case "changed" -> {
                    result.append("  - ")
                            .append(key)
                            .append(": ")
                            .append(value1)
                            .append("\n")
                            .append("  + ")
                            .append(key)
                            .append(": ")
                            .append(value2)
                            .append("\n");
                }
                case "added" -> {
                    result.append("  + ")
                            .append(key)
                            .append(": ")
                            .append(value1)
                            .append("\n");
                }
                case "removed" -> {
                    result.append("  - ")
                            .append(key)
                            .append(": ")
                            .append(value1)
                            .append("\n");
                }
                case "unchanged" -> {
                    result.append("    ")
                            .append(key)
                            .append(": ")
                            .append(value1)
                            .append("\n");
                }
                default -> {
                    throw new RuntimeException("Error value");
                }
            }
        }
        return result.append("}").toString();
    }
}
