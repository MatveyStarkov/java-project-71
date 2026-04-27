package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String dataFormat) throws IOException {

        switch (dataFormat) {
            case "json" -> {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(content, new TypeReference<>() {
                });
            }

            case "yaml", "yml" -> {
                ObjectMapper mapper = new YAMLMapper();
                return mapper.readValue(content, new TypeReference<>() {
                });
            }
            default -> throw new RuntimeException("Unexpected format: " + dataFormat);
        }
    }
}
