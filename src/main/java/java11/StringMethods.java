package main.java.java11;

public class StringMethods {
    public static void main(String[] args) {
        String str = "    sfdfsd dfsf";

        System.out.println(str.isBlank());
        System.out.println(str.lines());
        System.out.println(str.repeat(5));
        System.out.println(str.stripLeading());
        System.out.println(str.stripTrailing());
    }
}
