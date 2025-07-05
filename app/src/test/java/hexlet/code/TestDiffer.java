package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDiffer {

    @Test
    public void testNormal1() throws Exception  {
        String file1 = "../app/src/test/resources/file1.json";
        String file2 = "../app/src/test/resources/file2.json";
        String result = "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n";
        assertEquals(Differ.generate(file1, file2), result);
    }

    @Test
    public void testNormal2() throws Exception  {
        String file1 = "../app/src/test/resources/file2.json";
        String file2 = "../app/src/test/resources/file1.json";
        String result = "  + follow: false\n"
                + "    host: hexlet.io\n"
                + "  + proxy: 123.234.53.22\n"
                + "  - timeout: 20\n"
                + "  + timeout: 50\n"
                + "  - verbose: true\n";
        assertEquals(Differ.generate(file1, file2), result);
    }

    @Test
    public void testEqual() throws Exception  {
        String file1 = "../app/src/test/resources/file1.json";
        String file2 = "../app/src/test/resources/file1.json";
        String result = "    follow: false\n"
                + "    host: hexlet.io\n"
                + "    proxy: 123.234.53.22\n"
                + "    timeout: 50\n";
        assertEquals(Differ.generate(file1, file2), result);
    }

    @Test
    public void testEmpty() throws Exception  {
        String file1 = "";
        String file2 = "";
        String result = "";
        assertEquals(Differ.generate(file1, file2), result);
    }
}
