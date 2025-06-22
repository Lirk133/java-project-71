package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Engine {

    public static void run(String filePath1, String filePath2) {
        Map<String, String> fileMap1 = fileInMap(filePath1);
        Map<String, String> fileMap2 = fileInMap(filePath2);

        System.out.println(fileMap1);
        System.out.println(fileMap2);
    }

    private static Map<String, String> fileInMap(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        var path = Paths.get(filePath).toAbsolutePath().normalize();
        String file;
        Map<String, String> fileMap;

        try {
            file = Files.readString(path).trim();
            fileMap = mapper.readValue(file, new TypeReference<Map<String, String>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fileMap;
    }
}
