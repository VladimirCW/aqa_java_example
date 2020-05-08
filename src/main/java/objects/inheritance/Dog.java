package main.java.objects.inheritance;

public class Dog extends Animal implements IAttackable {
    private static int counter = 0;

    public Dog() {
        this("undefined");
    }

    Dog(String name) {
        super(name);
        Dog.counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public String introduce() {
        String entityName = "Dog";
        return super.introduce(entityName);
    }

    public void bark() {
        System.out.println(" Gav-Gav");
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return this.getName() + " and I am a dog!";
    }

    public void sleep() {
        System.out.println("Dog sleeps .....");
    }


}
