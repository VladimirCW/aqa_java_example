package test.java.unit.inheritance;

import org.testng.annotations.*;

public class BaseTestSetup {

    @Parameters({"browser"})
    @BeforeClass
    public static void beforeClass(@Optional("chrome") String param) {
        System.out.println(" -- I am before class inheritance with parameter " + param);
    }

    @BeforeMethod
    public static void beforeMethod() {
        System.out.println(" - I am before method inheritance");
    }

    @AfterMethod
    public static void afterMethod() {
        System.out.println(" - I am after method inheritance");
    }
}
