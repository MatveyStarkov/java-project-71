package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class Differ {

    public static String generate(String path1, String path2, String format) throws IOException {
        Path filePath1 = Path.of(path1).toAbsolutePath().normalize();
        Path filePath2 = Path.of(path2).toAbsolutePath().normalize();

        String whatInside1 = Files.readString(filePath1);
        String whatInside2 = Files.readString(filePath2);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> parsedData1 = mapper.readValue(whatInside1, Map.class);
        Map<String, Object> parsedData2 = mapper.readValue(whatInside2, Map.class);

        return ("\nfile1: \n" + parsedData1 + "\n" + "\nfile2: \n" + parsedData2);
    }
}


