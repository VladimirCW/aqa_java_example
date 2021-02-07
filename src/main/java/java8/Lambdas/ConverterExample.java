package main.java.java8.Lambdas;

import java.util.Arrays;
import java.util.List;

public class ConverterExample {

    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("123", "0", "456");

        IConverter converter = from -> Integer.valueOf((String) from);

        //Integer converted = (Integer) converter.convert(numbers.get(0));
        Integer converted = (Integer) converter.convert(numbers.get(0));

        System.out.println(converted);

        numbers.stream().map(Integer::valueOf).forEach(System.out::print);
    }
}
