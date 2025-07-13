package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {

    String result1 = """
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                """;
    String result2 = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'
                """;
    String result3 = "{\"setting2\":300,"
            + "\"key1\":\"value1\","
            + "\"setting3\":\"none\","
            + "\"key2\":\"value2\","
            + "\"chars2\":false,"
            + "\"setting1\":\"Another value\","
            + "\"chars1\":[\"a\",\"b\",\"c\"],"
            + "\"numbers4\":[4,5,6],"
            + "\"numbers3\":[3,4,5],"
            + "\"numbers2\":[22,33,44,55],"
            + "\"numbers1\":[1,2,3,4],"
            + "\"obj1\":{\"nestedKey\":\"value\","
            + "\"isNested\":true},"
            + "\"default\":[\"value1\","
            + "\"value2\"],"
            + "\"checked\":true,"
            + "\"id\":null}";

    @Test
    public void testNormalJSON() {
        String file1 = "../app/src/test/resources/file1.json";
        String file2 = "../app/src/test/resources/file2.json";

        assertEquals(result1, Differ.generate(file1, file2, "stylish"));
        assertEquals(result2, Differ.generate(file1, file2, "plain"));
        assertEquals(result3, Differ.generate(file1, file2, "json"));
    }

    @Test
    public void testNormalYAML() {
        String file1 = "../app/src/test/resources/file1.yml";
        String file2 = "../app/src/test/resources/file2.yml";

        assertEquals(result1, Differ.generate(file1, file2, "stylish"));
        assertEquals(result2, Differ.generate(file1, file2, "plain"));
        assertEquals(result3, Differ.generate(file1, file2, "json"));
    }

    @Test
    public void testEmpty() {
        String file1 = "";
        String file2 = "";
        String result = "";
        assertEquals(result, Differ.generate(file1, file2, "stylish"));
    }
}
