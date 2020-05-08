package main.java.primitives;

public class I_If_logic_and_or {
    public static void main(String[] args) {
        /*if (true) {
            System.out.println("main.java.primitives.First");
        } else {
            System.out.println("Second");
        }
        boolean a = true;
        if (a) {
            System.out.println("main.java.primitives.First");
        } else {
            System.out.println("Second");
        }*/
        /*int a = 10;
        int b = 20;
        if(a < b) {
            System.out.println("main.java.primitives.First");
        } else if (a == b) {
            System.out.println("Second");
        } else if (a > b) {
            System.out.println("Third");
        } else {
            System.out.println("Fourth");
        }*/
        int age = 20;
        String name = "Vasya";
        if(age > 18 && name == "Vasya") {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if(age < 18 || name == "Vasya") {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        /*String status;
        if(age <= 18) {
            status = "Student";
        } else {
            status = "Employee";
        }*/
        String status = age <= 18 ? "Student" : "Employee";
        System.out.println(status);
    }
}
