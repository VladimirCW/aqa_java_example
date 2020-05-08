package test.java.unit;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test()
    public static void test1() {
        System.out.println("-I am a Test # 1");
    }

    @Test(timeOut = 40000)
    public static void test2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("-I am a Test # 2");
    }

    @Test
    public static void test3() {
        System.out.println("-I am a Test # 3");
    }
}
