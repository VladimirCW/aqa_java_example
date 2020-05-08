package main.java.objects.inheritance;

public class Main2 {
    public static void main(String[] args) {
        Cat vasiliy = new Cat("Vasiliy");
        vasiliy.setAge(50);
        Cat petr = vasiliy;
        petr.setAge(90);
        Cat victor = new Cat("Vasiliy");

        Animal dog1 = new Dog("A");
        Animal horse1 = new Horse("B");

        dog1.sleep();
        ((Dog)dog1).bark();
        /*System.out.println(vasiliy == victor);
        System.out.println(vasiliy == petr);
        System.out.println("Vasiliy age is: " + vasiliy.getAge());
        System.out.println("Petr age is: " + petr.getAge());*/
    }
}
