package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PlainFormatter {

    public static String formatter(String key, Object value1, Object value2) {
        value1 = inString(value1);
        value2 = inString(value2);

        if (Objects.equals(value1, value2)) {
            return  "";
        } else if (value1 == "null") {
            return  "Property '" + key + "' was added with value: " + value2 + "\n";
        } else if (value2 == "null") {
            return  "Property '" + key + "' was removed\n";
        } else {
            return  "Property '" + key + "' was updated. From " + value1 + " to " + value2 + "\n";
        }
    }

    private static Object inString(Object value) {
        if (value == "null") {
            return "null";
        } else if (value instanceof Map || value instanceof List) {
            value = "[complex value]";
        } else if (value instanceof String) {
            value = "'" + value + "'";
        }
        return value;
    }
}
