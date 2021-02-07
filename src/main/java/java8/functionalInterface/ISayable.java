package main.java.java8.functionalInterface;

/**
 * Also known as Single Abstract Method Interfaces or SAM Interfaces
 * A functional interface can extends another interface only when it does not have any abstract method.
 */
@FunctionalInterface
public interface ISayable {

    /**
     * Functional interface can have only 1 method
     * @param msg
     */
    void say(String msg);


    /**
     * Can contain any number of Object class methods
     * @return
     */
    int hashCode();

    String toString();

    boolean equals(Object obj);

    // final methods can not be declared
    // String getClass();
}
