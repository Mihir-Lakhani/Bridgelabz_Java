package Java_BufferedReaderFileReaderInputStreamReader.StringBuilder;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.IOException;


public class ReverseAString {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        StringBuilder text = new StringBuilder();
        StringBuilder reversed = new StringBuilder();


        int value;
        while ((value = isr.read()) != -1 && value != '\n'){
            text.append((char)value);
            reversed.insert(0, (char) value);
        }

        System.out.println(text);
        System.out.println(reversed);
        System.out.println(text.reverse());


    }
}