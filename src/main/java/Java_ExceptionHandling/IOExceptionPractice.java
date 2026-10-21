package Java_ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOExceptionPractice {
    public static void main(String[] args) {
        String filepath = "src/main/java/Java_ExceptionHandling/data1.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: data1.txt");
        } catch (IOException e) {
            System.out.println("Could not read the file: " + e.getMessage());
        }
    }
}
