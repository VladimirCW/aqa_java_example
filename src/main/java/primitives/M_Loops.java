package main.java.primitives;

public class M_Loops {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello" + i);
        }

        int counter = 0;
        do {
            System.out.println("Hello");
            counter++;
        } while (counter < 10);

        int counter2 = 0;
        while (counter2 < 10) {
            System.out.println("HEllo");
            counter2++;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println("I = " + i);
        }

        int[] arr = {2, 4, 6, 8};
        for (int el: arr) {
            System.out.println("FOREACH" + el);
        }

        /*String str = "Hello world"; // not applicable
        for (String el: str) {
            System.out.printf("*%s*", el);
        }*/
    }
}
