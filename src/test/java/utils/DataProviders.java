package test.java.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "dp1")
    private Object[][] dp1() {
        return new Object[][]{
                {"Vova", 50},
                {"Petya", 80}
        };
    }
}
