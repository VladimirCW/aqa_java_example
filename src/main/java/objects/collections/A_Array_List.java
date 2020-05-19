package main.java.objects.collections;

import main.java.objects.inheritance.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_Array_List {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(5);
        list.add("Hello");
        list.add(new Dog());

        /*for(Object el: list) {
            System.out.println(el);
        }*/
        List<Number> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1.5);
        list1.remove(0);
        System.out.println(list.get(2));
        ArrayList<ArrayList<Number>> list2 = new ArrayList<>();

        ArrayList<Comparable<Double>> list3 = new ArrayList<>();
        list3.add((double)51);
        list3.add(5.6);
        if(list3.get(0).compareTo((Double) list3.get(1)) > 0) {
            System.out.println("OK");
        }
        System.out.println("*******************");
        Integer[] arr = {45, 89, 78, 89};
        List<Integer> list5 = new ArrayList(Arrays.asList(arr));
        for (Integer el: list5) System.out.println(el);
    }
}
