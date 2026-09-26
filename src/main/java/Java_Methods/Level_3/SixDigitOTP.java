package Java_Methods.Level_3;

import java.util.Arrays;
import java.util.Scanner;

public class SixDigitOTP {
    public static int[] GenerateOTP() {

        int[] OTPs = new int[10];
        int index = 0;
        while (index < 10) {
            // 000000 to 999999
            OTPs[index] = (int) (Math.random() * 1000000);
            index++;
        }
        return OTPs;
    }

    public static boolean isUnique(int[] arr){

        for (int i = 0; i< arr.length-1; i++){
            for (int j = i+1; j<arr.length-2; j++){
                if (arr[i]==arr[j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){

        int[] OTPs = GenerateOTP();
        System.out.printf("The Generated OTPs are: %s\nAll of them are %s Unique", Arrays.toString(OTPs), (isUnique(OTPs)) ? "Indeed" : "Not");
    }

}