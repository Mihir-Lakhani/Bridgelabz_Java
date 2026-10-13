package Java_BufferedReaderFileReaderInputStreamReader.InputStreamReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsoleCharacters {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream("src/main/java/Java_BufferedReaderFileReaderInputStreamReader/BFRDExampleFile.txt"));
        StringBuilder text = new StringBuilder();

        System.out.println("Enter some text:");

        int value;

        while ((value = reader.read()) != -1 && value != '\t') {
            if (value != '\r') {
                System.out.println((char)value);
                text.append((char) value);
            }
        }

        System.out.println("You entered: " + text);
    }
}