package test.java.unit;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {

    @Parameters({"login", "passw"})
    @Test
    public static void test1(@Optional("Alex") String userName, @Optional("456") String userPassw) {
        System.out.println("Name: " + userName);
        System.out.println("Password: " + userPassw);
    }
}
