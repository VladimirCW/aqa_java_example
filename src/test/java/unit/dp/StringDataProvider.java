package test.java.unit.dp;

import org.testng.annotations.DataProvider;

public class StringDataProvider {
    @DataProvider(name = "strings")
    public static Object[][] getData() {
        return new Object[][] {
                {"AAA", "aaa"},
                {"BBB", "bbb"},
                {"CCC", "ccc"}
        };
    }

    @DataProvider(name = "integers")
    public static Object[][] getData2() {
        return new Object[][] {
                {111, "aaa"},
                {222, "bbb"},
                {333, "ccc"}
        };
    }
}
