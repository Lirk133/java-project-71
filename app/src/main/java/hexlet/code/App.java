package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
//import picocli.CommandLine.Option;
//import picocli.CommandLine.Parameters;

@Command(name = "gendiff", version = "gendiff pre-alfa 0.0.0.1", mixinStandardHelpOptions = true,
        description = "Сравнивает два конфигурационных файла и показывает разницу.")
public class App implements Runnable {

//    @Option(names = { "-s", "--font-size" }, description = "Font size")
//    int fontSize = 19;

//    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
//            description = "Words to be translated into ASCII art.")
//    private String[] words = { "Hello,", "picocli" };

    @Override
    public void run() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}