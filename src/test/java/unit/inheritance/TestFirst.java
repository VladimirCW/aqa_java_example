package test.java.unit.inheritance;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFirst extends BaseTestSetup {

    /*@BeforeMethod
    public static void beforeMethod() {
        System.out.println(" - Additional before method for inheritance");
    }*/
    @BeforeMethod
    public static void before() {
        System.out.println(" - Additional before method for inheritance");
    }

    @Test
    public static void test1() {
        System.out.println("Inheritance test");
    }
}
