package Java_BufferedReaderFileReaderInputStreamReader.BufferedReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class ConsoleInputExample {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter your name: ");
            String name = br.readLine();
            System.out.println(name);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}