package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Command(name = "gendiff",
        version = "gendiff pre-alfa 0.0.0.1",
        mixinStandardHelpOptions = true,
        description = "Сравнивает два конфигурационных файла и показывает разницу.")
public class App implements Runnable {

    @Option(names = {"-f", "--format"}, 
            description = "выходной формат [по умолчанию: stylish]",
            defaultValue = "stylish")
    private String format;

    @Parameters(paramLabel = "filepath1",
            description = "путь до первого файла")
    private String filepath1;

    @Parameters(paramLabel = "filepath2",
            description = "путь до второго файла")
    private String filepath2;

    @Override
    public void run() {
        Engine.run(filepath1, filepath2);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}