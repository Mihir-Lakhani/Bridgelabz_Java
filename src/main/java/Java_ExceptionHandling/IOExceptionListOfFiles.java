package Java_ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class IOExceptionListOfFiles {

    static void processFiles(List<String> filePaths) {
        for (String filePath : filePaths) {
            System.out.println("Reading file: " + filePath);
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Could not read " + filePath + ": " + e.getMessage());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String folder = "src/main/java/Java_ExceptionHandling/";
        processFiles(List.of(folder + "data1.txt", folder + "data2.txt"));
    }
}
