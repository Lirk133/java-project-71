package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff",
        version = "gendiff pre-alfa 0.0.0.1",
        mixinStandardHelpOptions = true,
        description = "Сравнивает два конфигурационных файла и показывает разницу.")
public class App implements Runnable {

    @Option (names = {"-f", "--format"},
            description = "выходной формат [по умолчанию: stylish]",
            defaultValue = "stylish")
    private String format;

    @Parameters(paramLabel = "filepath1",
            description = "путь до первого файла")
    private String filePath1;

    @Parameters(paramLabel = "filepath2",
            description = "путь до второго файла")
    private String filePath2;

    @Override
    public void run() {
        System.out.println(Differ.generate(filePath1, filePath2));
    }

    public static void main(String[] args) {

//        String file1 = "../app/src/test/resources/file1.json";
//        String file2 = "../app/src/test/resources/file2.json";
//        System.out.println(Differ.generate(file1, file2));

        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
