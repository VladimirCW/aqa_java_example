package main.java.primitives;

public class P_StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(' ');
        for (int i = 0; i < 10; i++) {
            sb.append('*');
        }
        System.out.println(sb.toString());
    }
}
