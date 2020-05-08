package main.java.objects.inheritance;

public class Cat extends Animal{
    private static int counter = 0;

    Cat() {
        this("undefined");
    }

    Cat(String name) {
        super(name);
        Cat.counter++;
        System.out.println("Initialized Cat constructor");
    }

    public static int getCounter() {
        return counter;
    }

    public String introduce() {
        String entityName = "Cat";
        return super.introduce(entityName);
    }

    public void miew() {
        System.out.println("Miew-miew");
    }

    public void attack(IAttackable animal) {
        super.attack(animal, 10);
    }
}
