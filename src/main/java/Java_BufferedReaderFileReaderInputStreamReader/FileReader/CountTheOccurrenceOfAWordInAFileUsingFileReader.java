/*
FileReader Problem 2: Count the Occurrence of a Word in a File Using FileReader
Problem:
Write a program that uses FileReader and BufferedReader to read a file and count how many times a specific word appears in the file.
Approach:
Create a FileReader to read from the file and wrap it in a BufferedReader.
Initialize a counter variable to keep track of word occurrences.
For each line in the file, split it into words and check if the target word exists.
Increment the counter each time the word is found.
Print the final count.
 */

package Java_BufferedReaderFileReaderInputStreamReader.FileReader;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CountTheOccurrenceOfAWordInAFileUsingFileReader {
    public static void main(String[] args) throws IOException{

        String filePath = "src/main/java/Java_BufferedReaderFileReaderInputStreamReader/BFRDExampleFile.txt";

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line;
        int count = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the taget word");
        String target = sc.next();
        sc.nextLine();

        while((line = br.readLine()) != null){
            String[] words = line.split(" ");
            System.out.println(line);
            System.out.println("No of Words: " +words.length);


            for (String word : words){
                if(word.equalsIgnoreCase(target)){ count++; }
            }
        }
        System.out.printf("The word \"%s\" appears %d times.%n", target, count);


    }
}