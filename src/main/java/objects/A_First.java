package main.java.objects;

public class    A_First {
    /**
     *
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("main.java.objects.Test");
        /*Test test = new Test();
        Test test2 = new Test();
        test.name = "B";
        test.toString();
        System.out.printf(test.name);*/
    }
}

class Test {
    String name = "A";
    static {
        System.out.println("INITIALIZED");
    }
}
