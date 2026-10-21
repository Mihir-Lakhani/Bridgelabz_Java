package Java_ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CombineFiles {

    static void combineFiles(String firstPath, String secondPath, String outputPath) {
        try (BufferedReader first = new BufferedReader(new FileReader(firstPath));
             BufferedReader second = new BufferedReader(new FileReader(secondPath));
             FileWriter output = new FileWriter(outputPath)) {

            String line;
            while ((line = first.readLine()) != null) {
                output.write(line + System.lineSeparator());
            }
            while ((line = second.readLine()) != null) {
                output.write(line + System.lineSeparator());
            }
            System.out.println("Combined file created: " + outputPath);
        } catch (IOException e) {
            System.out.println("Could not combine the files: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String folder = "src/main/java/Java_ExceptionHandling/";
        combineFiles(folder + "data1.txt", folder + "data2.txt", folder + "combined.txt");
    }
}
