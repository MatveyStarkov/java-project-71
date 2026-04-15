package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String path1, String path2, String format) throws IOException {

        String content1 = readFile(path1);
        String content2 = readFile(path2);

        Map<String, Object> parsedData1 = Parser.parse(content1, format);
        Map<String, Object> parsedData2 = Parser.parse(content2, format);

        List<Map<String, Object>> x = FileComparator.compare(parsedData1, parsedData2);

        //System.out.println(x);
        //return ("\nfile1: \n" + parsedData1 + "\n" + "\nfile2: \n" + parsedData2);
        return Difference.differenceSearch(x);

    }

    public static String generate(String path1, String path2) throws IOException {
        String content1 = readFile(path1);
        String content2 = readFile(path2);

        Map<String, Object> parsedData1 = Parser.parse(content1, "stylish");
        Map<String, Object> parsedData2 = Parser.parse(content2, "stylish");

        List<Map<String, Object>> x = FileComparator.compare(parsedData1, parsedData2);

        return Difference.differenceSearch(x);
    }


    public static String readFile(String path) throws IOException {
        Path normPath = Path.of(path).toAbsolutePath().normalize();
        String whatInside = Files.readString(normPath);
        return whatInside;
    }

//    public static Map<String, Object> parse(String content) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> parsedData = mapper.readValue(content, Map.class);
//        return parsedData;
//    }


//    public static String format(Object diff) {
//
//        return null;
//    }

}


