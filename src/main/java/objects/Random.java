package main.java.objects;

import java.util.HashSet;
import java.util.Set;

public class Random {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int max = 10;
        int min = 5;
        for (int i = 0; i < 10000000; i++) {
            int rand = (int)( Math.random() * (max + 1 - min) + min);
            set.add(rand);
        }
        for (Integer el: set) System.out.println(el);;
    }
}
