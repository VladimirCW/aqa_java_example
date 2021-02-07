package main.java.java8.streams;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("AAA", 20));
        persons.add(new Person("BBB", 18));
        persons.add(new Person("CCC", 40));
        persons.add(new Person("DDD", 60));
        persons.add(new Person("ZZZ", 20));
        persons.add(new Person("AAA", 50));
        persons.add(new Person("YYY", 10));

        //for (Person person: persons) System.out.println(person);

        persons.stream()
                .filter(p -> p.getName().equals("AAA"))
                .sorted((a, b) -> b.getAge() - a.getAge())
                //.map(Person::getName)
                //.map(p -> p.getName())
                .forEach(System.out::println);
    }
}
