package main.java.objects.inheritance;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsic");
        Cat cat2 = new Cat();
        Dog dog = new Dog("main.java.primitives.First dog");
        IAttackable[] animalsAtackable = {new Dog(), new Horse("Bob")};

        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(cat.introduce());
        System.out.println(dog.introduce());
        Dog dog2 = new Dog("Second dog");
        Dog dog3 = new Dog("Third dog");
        dog.setAge(50);
        dog2.setAge(80);
        dog3.setAge(10);
//        System.out.println("Count animals " + Animal.getCounter());
//        System.out.println("Count cats " + Cat.getCounter());
//        System.out.println("Count dogs " + Dog.getCounter());
//        System.out.println("Health dog " + dog.getHealth());
        cat.attack(dog);
        cat.attack(dog);
        cat.attack(dog);
        cat.attack(dog2);
        Dog[] arr = {dog3, dog, dog2};
        //Arrays.sort(arr);
        //main.java.primitives.First approach
        /*Animal.CompareByAge aca = new Dog().new CompareByAge();
        Arrays.sort(arr, aca);*/
        //Second approach
        //Arrays.sort(arr, new Dog.CompareByAge());
        //Third Fourth approach
        //Arrays.sort(arr, Dog.compareByAge());
        //Fifth approach
        /*Arrays.sort(arr, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/
        //Sixth approach
        Arrays.sort(arr, (Dog d1, Dog d2) -> d1.getAge() - d2.getAge());
        for (Dog el: arr) {
            System.out.println(el);
        }
        //dog.attack(cat);
        System.out.println("Health dog " + dog.getHealth());
        System.out.println("Health dog2 " + dog2.getHealth());
        System.out.println("Health cat " + cat.getHealth());

        System.out.println("**************************************");
        Animal[] animals = {new Dog("Bobik"), new Cat()};
        for(Animal animal: animals) {
            if(animal instanceof Dog) ((Dog)animals[0]).bark();
            else if (animal instanceof Cat) ((Cat)animals[1]).miew();
        }
        //System.out.println(animal.toString());
    }
}
