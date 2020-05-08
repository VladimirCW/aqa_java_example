package main.java.patterns;

public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {

    }

    public static synchronized Singleton getInstance() {
        if(Singleton.instance == null) instance = new Singleton();
        return instance;
    }
}
