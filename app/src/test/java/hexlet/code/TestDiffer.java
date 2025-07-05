package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {

    @Test
    public void testNormal1() {
        String file1 = "../app/src/test/resources/file1.json";
        String file2 = "../app/src/test/resources/file2.json";
        String result1 = """
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                """;
        String result2 = """
                  + follow: false
                    host: hexlet.io
                  + proxy: 123.234.53.22
                  - timeout: 20
                  + timeout: 50
                  - verbose: true
                """;
        String result3 = """
                    follow: false
                    host: hexlet.io
                    proxy: 123.234.53.22
                    timeout: 50
                """;
        assertEquals(result1, Differ.generate(file1, file2));
        assertEquals(result2, Differ.generate(file2, file1));
        assertEquals(result3, Differ.generate(file1, file1));
    }

    @Test
    public void testEmpty() {
        String file1 = "";
        String file2 = "";
        String result = "";
        assertEquals(result, Differ.generate(file1, file2));
    }
}
