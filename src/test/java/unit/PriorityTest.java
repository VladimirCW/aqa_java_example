package test.java.unit;

import org.testng.annotations.Test;

public class PriorityTest {
    @Test(priority = 3)
    public static void test1() {
        System.out.println("-I am a Test # 1");
    }

    @Test(priority = 2)
    public static void test2() {
        System.out.println("-I am a Test # 2");
    }

    @Test(priority = 1)
    public static void test3() {
        System.out.println("-I am a Test # 3");
    }
}
