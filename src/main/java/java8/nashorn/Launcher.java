package main.java.java8.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Launcher {
    public static void main(String[] args) throws FileNotFoundException, ScriptException {
        ScriptEngine se = new ScriptEngineManager().getEngineByName("Nashorn");
        //se.eval(new FileReader("test.js")); (No such file or directory)
        se.eval("print('Hello Nashorn!!!')");
    }
}
