package hexlet.code;

import java.util.*;

public class Compare {
    public static List<Map<String, Object>> compare(Map<String, Object> file1, Map<String, Object> file2) {

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        Set<String> keys = new TreeSet<String>();

        keys.addAll(file1.keySet());
        keys.addAll(file2.keySet());

        for(String key : keys) {

            Object value1 = file1.get(key);
            Object value2 = file2.get(key);

            HashMap<String, Object> diff = new HashMap<>();

            diff.put("key", key);

            if (!file2.containsKey(key)) {
                diff.put("status", "removed");
                diff.put("value1", value1);
                result.add(diff);
            } else if (!file1.containsKey(key)) {
                diff.put("status", "added");
                diff.put("value1", value2);
                result.add(diff);
            } else if ((file1.containsKey(key) && file2.containsKey(key) && !value1.equals(value2))) {
                diff.put("status", "changed");
                diff.put("value1", value1);
                diff.put("value2", value2);
                result.add(diff);
            } else {
                diff.put("status", "unchanged");
                diff.put("value1", value1);
                result.add(diff);
            }
        }
        return result;
    }
}
