package main.java.java8.IntefaceDefaultMethods;

public interface IExampleable {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
