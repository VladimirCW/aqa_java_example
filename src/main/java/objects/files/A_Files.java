package main.java.objects.files;

import java.io.*;

public class A_Files {
    public static void main(String[] args) throws IOException {
//        File file = new File("test.txt");
//        file.createNewFile();
        File dir = new File(".");
        File[] files = dir.listFiles(filePath -> filePath.getName().equals("test.txt"));
        for (File el: files) {
            //System.out.println(el.getName().equals("test.txt"));
            System.out.println(el.getName());
        }

        //writeToFile("hello");
        String str;
        try {
            str = readFromFile("test.txt");
            System.out.println(str);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    private static String readFromFile(String s) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(s), "cp1251"));
        //BufferedReader reader = new BufferedReader(new FileReader(s));
        return reader.readLine();
    }

    private static void writeToFile(String hello) throws IOException {
        FileWriter writer = new FileWriter("test.txt");
        writer.write(hello);
        //try с ресурсами
        /*try(FileWriter writer = new FileWriter("test.txt")) {
            writer.write(hello);
        } catch(IOException ioe) {

        }*/
    }
}
