package test.java.unit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreTest {

    @BeforeMethod(onlyForGroups = "first")
    public static void beforeMethodWithGroup() {
        System.out.println("I am before method with group");
    }
    @BeforeMethod()
    public static void beforeMethod() {
        System.out.println("I am before method");
    }

    @Ignore
    @Test()
    public static void test1() {
        System.out.println("-I am a Test # 1");
    }

    @Test(enabled = true, groups = {"first"})
    public static void test2() {
        System.out.println("-I am a Test # 2");
    }

    @Ignore
    @Test(invocationCount = 5, invocationTimeOut = 5000)
    public static void test3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("-I am a Test # 3");
    }

    @AfterMethod
    public static void afterMethod() {
        System.out.println("I am after method");
    }
}
