package hexlet.code.formatters;

import java.util.Objects;

public class StylishFormatter {

    public static String formatter(String key, Object value1, Object value2) {
        if (Objects.equals(value1, value2)) {
            return  "    " + key + ": " + value1 + "\n";
        } else if (value1 == "null") {
            return  "  + " + key + ": " + value2 + "\n";
        } else if (value2 == "null") {
            return  "  - " + key + ": " + value1 + "\n";
        } else {
            return  "  - " + key + ": " + value1 + "\n"
                    + "  + " + key + ": " + value2 + "\n";
        }
    }
}
