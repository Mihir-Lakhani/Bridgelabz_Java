/*
Linear Search Problem 2: Search for a Specific Word in a List of Sentences
Problem:
You are given an array of sentences (strings). Write a program that performs Linear Search to find the first sentence containing a specific word. If the word is found, return the sentence. If no sentence contains the word, return "Not Found".
Approach:
Iterate through the list of sentences.
For each sentence, check if it contains the specific word.
If the word is found, return the current sentence.
If no sentence contains the word, return "Not Found".
 */

package Java_Searching.LinearSearch;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SearchForASpecificWordInAListOfSentences {

    private static int findTheWord(String[] arr, String word){

        for(int i = 0; i < arr.length; i++){
            if (arr[i].contains(word)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] arr = new String[5];

        for (int i = 0; i < 5; i++){
            System.out.printf("Enter the Line %d:\n", i+1);
            arr[i] = sc.nextLine().toLowerCase();
        }

        System.out.println("Enter your target word: ");
        String target = sc.next().toLowerCase();
        sc.nextLine();

        int index = findTheWord(arr, target);
        if (index == -1){
            System.out.println("WE ARE REALLLYYYY SORRRYYY, WE COULD NOT FIND THE WORD IN THE ARRAY OF LINES");
        }else{
            System.out.println("Word found in line: "+arr[index]);
        }

    }
}