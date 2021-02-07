package main.java.java8.functionalInterface;

public class FunctionalInterfaceExample implements ISayable{

    public void say(String msg) {
        System.out.println(msg);
    }

    public static void main(String args[]) {
        FunctionalInterfaceExample example = new FunctionalInterfaceExample();
        example.say("Hi");
    }
}
