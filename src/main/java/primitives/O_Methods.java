package main.java.primitives;

public class O_Methods {
    public static void main(String[] args) {
        int res = summ2(2, 3);
        res = summ3(2, 3, 4);
    }

    private static int summ2(int i, int i1) {
        return i + i1;
    }

    private static int summ3(int i, int i1, int i2) {
        return i + i1 + i2;
    }

    private static int summ(int ...x) {
        return x[0];
    }

    //f(int a, long b)
    //f(long a, int b)

}
