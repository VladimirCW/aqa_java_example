package main.java.java11;

import com.sun.istack.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class VarVariable {
    public static void main(String[] args) {
        var i1 = 30;


        List<String> list = new ArrayList<>();

        list.add("AAA");
        list.add("BB");
        list.add("C");

        List<String> list1 = list.stream()
                .map((@NotNull var i) -> i.toLowerCase())
                .collect(Collectors.toList());
    }
}
