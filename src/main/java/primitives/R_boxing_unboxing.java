package main.java.primitives;

public class R_boxing_unboxing {
    public static void main(String[] args) {
        //System.out.println(a instanceof Integer);
//        switch (Integer.parseInt(args[0])) {
//            case 1:
//                System.out.println("FIRST");
//        }
        int c = 10;
        int d = 10;
        System.out.println(c == d);
        Integer e = new Integer(10);
        Integer f = new Integer(10);
        System.out.println(e == f);

    }
}
