package Java_BufferedReaderFileReaderInputStreamReader.StringBuffer;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ConcatenateStringsEfficientlyUsingStringBuffer {
    public static void main(String[] args) {


        String[] arr = {"Mihir", "Shrey", "Rishika"};
        StringBuffer newString = new StringBuffer("");

        for (int i = 0; i< arr.length; i++){
            newString.append(arr[i]);
            newString.append(" ");
        }

        System.out.println(newString);
    }
}