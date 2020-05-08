package main.java.primitives;

public class N_Cast {
    public static void main(String[] args) {
//        int a = 10;
//        long b = a;
        long a = 1234567890123L;
        int b = (int) a;
        short c = -65;
        char d = (char) c;
//        System.out.println("A = " + a);
//        System.out.println("B = " + b);
//        System.out.println("C = " + c);
//        System.out.println("D = " + d);
        System.out.println((float) 1/2);
        int e = (int)1.5;
        System.out.println(e);
    }
}
