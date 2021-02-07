package main.java.primitives;

public class D_PrimitiveInt {
    public static void main(String[] args) {
        int a = 2147483647;
        int b = 'c';
        System.out.println(b);
        long l = 456;
        long l2 = 9223372036854775807L;
        System.out.println(l2);
        float c = 4.6F;
        float d = 4.6f;
        double e = 45333333.78;
        System.out.println(e);
        // numeric separators
        int thousand = 1_000;
        int billion = 1_000_000;
    }
}
