package main.java.patterns;

public class First {
    public static void main(String[] args) {
        Singleton st = Singleton.getInstance();
        Singleton st2 = Singleton.getInstance();
        System.out.println(st == st2);
    }
}
