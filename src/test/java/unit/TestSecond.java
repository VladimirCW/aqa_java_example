package test.java.unit;

import org.testng.annotations.Test;

@Test(groups = {"class"})
public class TestSecond {

    @Test(groups = {"method"})
    public void test1() {
        String[] arr = {"vova", "Vasili", "Petr"};
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] + (i < arr.length - 1 ? ", " : "");
        }
        System.out.println(result);
        System.out.println("HEllo");
        System.out.println(result.split(", ").length);
        for (String el: result.split(", ")) {
            System.out.println(Character.toString(el.charAt(0)).toUpperCase().equals(Character.toString(el.charAt(0))));
        }
    }
}
