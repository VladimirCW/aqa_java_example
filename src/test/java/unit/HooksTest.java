package test.java.unit;

import org.testng.annotations.*;

public class HooksTest {
    public static String getStatus(int age) {
        if(age < 18) {
            return "Student";
        } else {
            return "Worker";
        }
    }

    @BeforeClass
    public static void setUp() {
        System.out.println("---I will be triggered ones before all tests in the spec file");
    }

    @BeforeMethod
    public static void beforeEach() {
        System.out.println("--I will be triggered before every Test");
    }

    @Test()
    public static void test1() {
        System.out.println("-I am a Test # 1");
    }

    @Test
    public static void test2() {
        System.out.println("-I am a Test # 2");
    }

    @Test
    public static void test3() {
        System.out.println("-I am a Test # 3");
    }

    @AfterMethod
    public static void afterEach() {
        System.out.println("--I will be triggered after each Test");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("---I will be triggered ones after all tests in the spec file");
    }
}
