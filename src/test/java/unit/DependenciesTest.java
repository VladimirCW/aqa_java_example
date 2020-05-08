package test.java.unit;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DependenciesTest {

    @Test(dependsOnMethods = "test2", alwaysRun = true)
    public static void test1() {
        System.out.println("-I am a Test # 1");
    }

    @Test(dependsOnGroups = "method")
    public static void test2() {
        System.out.println("-I am a Test # 2");
    }

    @Test(groups = {"method", "second"})
    public static void test3() {
        assertEquals(true, true);
        System.out.println("-I am a Test # 3");
    }
    @Test(dependsOnGroups = ".*ond")
    public static void test4() {
        System.out.println("-I am a Test # 3");
    }
    @Test(groups = {"fond"})
    public static void test5() {
        System.out.println("-I am a Test # 3");
    }

}
