package Java_BufferedReaderFileReaderInputStreamReader.InputStreamReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsoleCharacters {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        StringBuilder text = new StringBuilder();

        System.out.println("Enter some text:");

        int value;

        while ((value = reader.read()) != -1 && value != '\t') {
            if (value != '\r') {
                text.append((char) value);
            }
        }

        System.out.println("You entered: " + text);
    }
}