package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Differ {

    public static String generate(String filePath1, String filePath2, String format) {

        if (filePath1.isEmpty() || filePath2.isEmpty()) {
            return "";
        }

        Map<String, Object> file1 = Parser.fileInMap(filePath1);
        Map<String, Object> file2 = Parser.fileInMap(filePath2);

        if (format.equals("json")) {
            Map<String, Object> map = new HashMap<>();
            map.putAll(file1);
            map.putAll(file2);
            return JsonFormatter.formatter(map);
        }

        Set<String> allKeys = Stream
                .concat(file1.keySet().stream(), file2.keySet().stream())
                .collect(Collectors.toSet());

        return allKeys.stream()
                .sorted()
                .map(key -> {

                    Object value1 = file1.getOrDefault(key, "null");
                    Object value2 = file2.getOrDefault(key, "null");

                    return equalValue(key, value1, value2, format);
                })
                .collect(Collectors.joining());
    }

    private static String equalValue(String key, Object value1, Object value2, String format) {
        String str = "";
        if (format.equals("stylish")) {
            str = StylishFormatter.formatter(key, value1, value2);
        } else if (format.equals("plain")) {
            str = PlainFormatter.formatter(key, value1, value2);
        }

        return str;
    }



}
