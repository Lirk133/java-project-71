package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, String> fileInMap(String filePath) {
        ObjectMapper mapper = new YAMLMapper();
        var path = Paths.get(filePath).toAbsolutePath().normalize();
        String file;
        Map<String, String> fileMap;

        try {
            file = Files.readString(path).trim();
            fileMap = mapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fileMap;
    }
}
