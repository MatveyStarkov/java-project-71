package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.io.IOException;

@Command(
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true,
        version = "app 0.1.0")

public class App implements Runnable {

    @Parameters(
            index = "0",
            paramLabel = "filePath1",
            description = "path to first file"
    )
    private String filePath1;

    @Parameters(
            index = "1",
            paramLabel = "filePath2",
            description = "path to second file"
    )
    private String filePath2;

    @Option(
            names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: stylish]",
            defaultValue = "stylish"
    )
    private String format;


    @Override
    public void run() {
        try {
//            System.out.println("file1: " + filePath1);
//            System.out.println("file2: " + filePath2);
//            System.out.println(("format: " + format));
            
            System.out.println(Differ.generate(filePath1, filePath2, format));
        } catch (IOException e) {
            System.out.println("error!");
        }

    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
