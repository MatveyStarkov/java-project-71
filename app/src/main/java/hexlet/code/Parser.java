package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String dataFormat) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> parsedData = mapper.readValue(content, Map.class);
        return parsedData;
    }
}
