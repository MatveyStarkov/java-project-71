package hexlet.code.formatters;

import java.io.IOException;
import java.util.Map;
import java.util.List;

public class Plain {
    public static String format(List<Map<String, Object>> x) throws IOException {
        StringBuilder result = new StringBuilder();
        for (var map : x) {
            Object value1 = map.get("value1");
            Object value2 = map.get("value2");
            Object key = map.get("key");
            switch (String.valueOf(map.get("status"))) {
                case "changed" -> result.append("Property ")
                        .append("'")
                        .append(key)
                        .append("'")
                        .append(" was updated. From ")
                        .append(normalize(value1))
                        .append(" to ")
                        .append(normalize(value2))
                        .append("\n");
                case "added" -> result.append("Property ")
                        .append("'")
                        .append(key)
                        .append("'")
                        .append(" was added with value: ")
                        .append(normalize(value1))
                        .append("\n");
                case "removed" -> result.append("Property ")
                        .append("'")
                        .append(key).append("'")
                        .append(" was removed")
                        .append("\n");
                case "unchanged" -> {

                }
                default -> {
                    throw new RuntimeException("Error value");
                }
            }
        }
        return result.toString().trim();
    }

    public static String normalize(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        }
        return String.valueOf(value);
    }
}
