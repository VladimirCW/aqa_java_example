package main.java.objects.inheritance;

import java.util.Comparator;

public abstract class Animal implements Comparable<Animal> {
    private static int counter = 0;
    private final String name;
    private int age = 1;
    protected int health = 100;
    static {
        System.out.println("Initialized base animal");
    }
    public Animal() {
        this("undefined");
    }

    public Animal(String name) {
        System.out.println("Animal constructor with name " + name);
        this.name = name;
        Animal.counter++;
    }

    public void sleep() {
        System.out.println("Animal sleeps .....    ");
    }

    public String getName() {
        return this.name;
    }

    public static int getCounter() {
        return counter;
    }

    public String introduce(String entityName) {
        return "Hello my name is " + this.name + " and I am a " + entityName;
    }

    public void attack(IAttackable animal, int power) {
        animal.setHealth(animal.getHealth() - power);
    }

    public int getHealth() {
        return this.health;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Animal o) {
        return o.health - this.health;
    }

    //main.java.primitives.First approach
    /*public class CompareByAge implements Comparator<Animal>  {

        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.age - o2.age;
        }
    }*/

    //Second approach
    public static class CompareByAge implements Comparator<Animal>  {

        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.age - o2.age;
        }
    }

    //Third approach

    /*public static Comparator<Animal> compareByAge() {
        class CMP implements Comparator<Animal>{

            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.age - o2.age;
            }
        }
        return new CMP();
    }*/

    //Fourth approach
    public static Comparator<Animal> compareByAge() {
        return new Comparator<Animal>() {
            //Инициализация экземпляром
            /*{
                System.out.println("Hello");
            }*/
            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.age - o2.age;
            }
        };
    }
}
