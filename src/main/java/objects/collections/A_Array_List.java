package main.java.objects.collections;

import main.java.objects.inheritance.Dog;

import java.util.ArrayList;

public class A_Array_List {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(5);
        list.add("Hello");
        list.add(new Dog());

        /*for(Object el: list) {
            System.out.println(el);
        }*/
        ArrayList<Number> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1.5);
        ArrayList<ArrayList<Number>> list2 = new ArrayList<>();

        ArrayList<Comparable<Double>> list3 = new ArrayList<>();
        list3.add((double)51);
        list3.add(5.6);
        if(list3.get(0).compareTo((Double) list3.get(1)) > 0) {
            System.out.println("OK");
        }
    }
}
