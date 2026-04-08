package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String dataFormat) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> parsedData = mapper.readValue(content, Map.class);
        return parsedData;

//        switch (dataFormat) {
//            case "yml":
//            case "yaml":
//            case "json":
//            default:
//        }
//        return null;
    }
}
