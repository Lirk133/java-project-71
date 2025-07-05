package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {

    @Test
    public void testNormal1() {
        String file1 = "../app/src/test/resources/file1.json";
        String file2 = "../app/src/test/resources/file2.json";
        String result = """
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                """;
        assertEquals(result, Differ.generate(file1, file2));
    }

    @Test
    public void testNormal2() {
        String file1 = "../app/src/test/resources/file2.json";
        String file2 = "../app/src/test/resources/file1.json";
        String result = """
                  + follow: false
                    host: hexlet.io
                  + proxy: 123.234.53.22
                  - timeout: 20
                  + timeout: 50
                  - verbose: true
                """;
        assertEquals(result, Differ.generate(file1, file2));
    }

    @Test
    public void testEqual() {
        String file1 = "../app/src/test/resources/file1.json";
        String file2 = "../app/src/test/resources/file1.json";
        String result = """
                    follow: false
                    host: hexlet.io
                    proxy: 123.234.53.22
                    timeout: 50
                """;
        assertEquals(result, Differ.generate(file1, file2));
    }

    @Test
    public void testEmpty() {
        String file1 = "";
        String file2 = "";
        String result = "";
        assertEquals(result, Differ.generate(file1, file2));
    }
}
