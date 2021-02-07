package main.java.java8.methodAndConstructorReference;

public class Program {
    public static void main(String[] args) {
        Sayable sayable = Person::sayTmh;

        sayable.say();

        Person person = new Person("Vasya");
        Sayable sayable1 = person::sayName;
        sayable1.say();

        Sayable sayable2 = new Person("Petya")::sayName;
        sayable2.say();

        Printable printable = System.out::println;
        printable.print("Hello printable interface");
    }

}
