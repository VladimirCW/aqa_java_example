package main.java.primitives;

public class K_switch {
    public static void main(String[] args) {
        System.out.println(args.length);
        //System.out.println(args[0]);
        String a = "Hello";
        switch (a) {
            case "Hello":
                System.out.println("111");
                break;
            case "By":
                System.out.println("222");
                break;
            default:
                System.out.println("not found");
        }
    }
}
