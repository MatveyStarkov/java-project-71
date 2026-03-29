package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String path1, String path2, String format) throws IOException {

        String content1 = readFile(path1);
        String content2 = readFile(path2);

        Map<String, Object> parsedData1 = parse(content1);
        Map<String, Object> parsedData2 = parse(content2);

        List<Map<String, Object>> x = Compare.compare(parsedData1, parsedData2);

        //System.out.println(x);
        //return ("\nfile1: \n" + parsedData1 + "\n" + "\nfile2: \n" + parsedData2);
        return Difference.difference(x);

    }


    public static String readFile(String path) throws IOException {
        Path normPath = Path.of(path).toAbsolutePath().normalize();
        String whatInside = Files.readString(normPath);
        return whatInside;
    }

    public static Map<String, Object> parse(String content) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> parsedData = mapper.readValue(content , Map.class);
        return parsedData;
    }


//    public static String format(Object diff) {
//
//        return null;
//    }

}


