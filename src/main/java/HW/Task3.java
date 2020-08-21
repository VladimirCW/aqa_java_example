package main.java.HW;

public class Task3 {
    public static void main(String[] args) {
        int strLength = 10;
        for (int i = 0; i < strLength; i++) {
            for (int j = 1; j <= strLength; j++) {
                System.out.print(j < (strLength - i) ? " " : "*");
            }
            System.out.println();
        }
    }
}
