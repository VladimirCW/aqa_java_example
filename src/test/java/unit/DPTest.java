package test.java.unit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.unit.dp.StringDataProvider;

import static org.testng.Assert.assertEquals;

public class DPTest {


    public static String getStatus(int age) {
        if(age < 18) {
            return "Student";
        } else {
            return "Worker";
        }
    }


    @Test(dataProvider = "statuses")
    public static void test1(int age, String expectedStatus) throws InterruptedException {
        Thread.sleep(2000);
        String actualStatus = getStatus(age);
        assertEquals(actualStatus, expectedStatus, String.format("Expected status '%s' for age '%d', but got status '%s'", expectedStatus, age, actualStatus));
    }

    @Test(dataProvider = "strings", dataProviderClass = StringDataProvider.class)
    public static void test2(String name1, String name2) {
        System.out.println("Test data provider class " + name1 + " " + name2);
    }

    @Test(dataProvider = "integers", dataProviderClass = StringDataProvider.class)
    public static void test3(int name1, String name2) {
        System.out.println("Test data provider class " + name1 + " " + name2);
    }

    @DataProvider(name="statuses", parallel = true)
    public Object[][] statusesData() {
        return new Object[][] {
                {50, "Worker"},
                {20, "Worker"},
                {10, "Student"}/*,
                {70, "Student"},*/
        };
    }
}
