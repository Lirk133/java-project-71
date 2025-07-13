package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Differ {

    public static String generate(String filePath1, String filePath2) {

        if (filePath1.isEmpty() || filePath2.isEmpty()) {
            return "";
        }

        Map<String, String> file1 = Parser.fileInMap(filePath1);
        Map<String, String> file2 = Parser.fileInMap(filePath2);

        Set<String> allKeys = Stream
                .concat(file1.keySet().stream(), file2.keySet().stream())
                .collect(Collectors.toSet());

        return allKeys.stream()
                .sorted()
                .map(key -> {
                    String value1 = file1.get(key);
                    String value2 = file2.get(key);

                    return equalValue(key, value1, value2);
                })
                .collect(Collectors.joining());
    }

    private static String equalValue(String key, String value1, String value2) {
        String str;

        if (Objects.equals(value1, value2)) {
            str = "    " + key + ": " + value1 + "\n";
        } else if (value1 == null) {
            str = "  + " + key + ": " + value2 + "\n";
        } else if (value2 == null) {
            str = "  - " + key + ": " + value1 + "\n";
        } else {
            str = "  - " + key + ": " + value1 + "\n";
            str += "  + " + key + ": " + value2 + "\n";
        }

        return str;
    }
}
