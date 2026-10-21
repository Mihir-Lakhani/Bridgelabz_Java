package Java_ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NestedTryFileParsing {

    static void readNumbers(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line);
                    System.out.println("Number: " + number);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid number: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readNumbers("src/main/java/Java_ExceptionHandling/numbers.txt");
    }
}
