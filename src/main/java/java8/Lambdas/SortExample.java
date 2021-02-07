package main.java.java8.Lambdas;

import java.util.*;

public class SortExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("AAA", "BBB", "CCC", "ZZZ", "DDD");

        /*Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });*/

        //Collections.sort(names, (a, b) -> a.compareTo(b));

        //Collections.sort(names, Comparator.reverseOrder());

        //Collections.sort(names, String::compareTo);

        names.sort(String::compareTo);

        for (String name: names) {
            System.out.println(name);
        }
    }
}
