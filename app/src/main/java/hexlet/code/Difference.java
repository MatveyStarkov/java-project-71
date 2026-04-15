package hexlet.code;

import java.util.List;
import java.util.Map;

public class Difference {
    public static String differenceSearch(List<Map<String, Object>> x) {
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
                default -> {
                    result.append("    ")
                            .append(key)
                            .append(": ")
                            .append(value1)
                            .append("\n");
                }
            }
        }
        return result.append("}").toString();
    }
}
