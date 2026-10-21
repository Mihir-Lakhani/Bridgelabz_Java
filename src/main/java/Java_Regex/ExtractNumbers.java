package Java_Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumbers {

    public static void main(String[] args) {
        String text = "Mihir has 2 books, 15 notes, and 100 questions.";
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
