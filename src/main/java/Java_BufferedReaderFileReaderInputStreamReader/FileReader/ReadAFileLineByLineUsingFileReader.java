/*
FileReader Problem 1: Read a File Line by Line Using FileReader
Problem:
Write a program that uses FileReader to read a text file line by line and print each line to the console.
Approach:
Create a FileReader object to read from the file.
Wrap the FileReader in a BufferedReader to read lines efficiently.
Use a loop to read each line using the readLine() method and print it to the console.
Close the file after reading all the lines.
 */

package Java_BufferedReaderFileReaderInputStreamReader.FileReader;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAFileLineByLineUsingFileReader {
    public static void main(String[] args) throws IOException {

        String filePath = "src/main/java/Java_BufferedReaderFileReaderInputStreamReader/BFRDExampleFile.txt";

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;

        while((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
}