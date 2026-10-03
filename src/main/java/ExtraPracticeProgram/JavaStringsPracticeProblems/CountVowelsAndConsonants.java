package ExtraPracticeProgram.JavaStringsPracticeProblems;

import java.util.Scanner;

public class CountVowelsAndConsonants {


    boolean vowelCheck(char ch){
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        for (char vowel : vowels){
            if (ch == vowel){
                return true;
            }
        }
        return false;
    }

    int[] Count(char[] charArray){

        int vowels = 0;
        int consonants = 0;

        for (int i=0; i<charArray.length; i++){
            if (Character.toUpperCase(charArray[i]) >= 65 && Character.toUpperCase(charArray[i]) <=90){
                if (vowelCheck(Character.toUpperCase(charArray[i]))){
                    vowels++;
                }else{
                    consonants++;
                }

            }
        }
        int[] ans = {vowels, consonants};
        return ans;



    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = sc.nextLine();

        CountVowelsAndConsonants obj = new CountVowelsAndConsonants();

        char[] charArray = str.toCharArray();
        int[] ans = obj.Count(charArray);

        System.out.printf("Number of Vowels: %d\n" +
                "Number of Consonants: %d", ans[0], ans[1]);



    }
}