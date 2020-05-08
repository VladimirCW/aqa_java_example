package test.java.unit;

import org.testng.annotations.Test;

public class TestFirst {

    @Test
    public static void test1() {
//        FilesList.getFiles(".");
        System.out.println(min(new int[]{2, 4, 6, 8, -10}));
    }

    public static int min(int[] arr) {
        String s = "*";
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(s);
            }
            System.out.println();
        }
        return 0;
    }
}
