package main.java.primitives;

public class F_String_Escape {
    public static void main(String[] args) {
        String a = "abc";
        System.out.println(a);
        String b = "Hello \"name\" \nnew line\tTAB\n\rnew line2\\\\";
        System.out.println(b);
        System.out.println(a.length());
    }
}
