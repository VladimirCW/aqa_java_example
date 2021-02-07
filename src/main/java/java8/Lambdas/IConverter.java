package main.java.java8.Lambdas;

@FunctionalInterface
public interface IConverter<T, F> {

    T convert(F from);
}
