package main.java.objects.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Set_Ex<I extends Number> {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(50);
        set.add(50);
        set.add(40);
        set.add(80);
        set.remove(40);
        for (Integer el: set) {
            System.out.println(el);
        }
        /*System.out.println("------------------");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("***");
            System.out.println(iterator.next());
        }*/

        Integer[] arr = {45, 89, 56, 456, 0, 0, 0, -5};
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(arr));
        Set<Integer> set3 = new HashSet();
        Collections.addAll(set3, arr);
        for (Integer el: set3) System.out.println(el);

        Integer[] newArr = set3.toArray(new Integer[0]);
        System.out.println("Array length: " + newArr.length);
    }
}
