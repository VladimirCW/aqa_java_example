package main.java.primitives;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T_RegEx {
    public static void main(String[] args) {
        /*String regex = ".+\\d{3}!.+";
        String text = "Hello 789! and 456! good by!";*/
        String regex = "80\\d{10}";
        String text = "+38(050)45678978";
        //String text = "+38-(050)-456-789-78".replaceAll("[()-]", "");
        //String text = "+38(050)45678978".replace("(", "").replace(")", "");
        Pattern pattern = Pattern.compile(regex);
        //Pattern pattern = Pattern.compile("Hello456789By", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            /*System.out.println(matcher.start());
            System.out.println(matcher.end());*/
            System.out.println("Result = " + text.substring(matcher.start(), matcher.end()));
        }
        System.out.println(Pattern.matches(regex, text));
    }
}
