/*
3. Program to Check Palindrome String
Problem Statement: Create a PalindromeChecker class with an attribute text.
Add methods to check if the text is a palindrome and display the result.
 */

package Java_ClassAndObjects.Level_2;

class PalindromeChecker{

    String text;

    PalindromeChecker(String text){
        this.text = text;
    }

    public boolean isPalindrome(){
        for (int i = 0; i < text.length() / 2; i++){
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public void displayResult(){
        if (isPalindrome()){
            System.out.println(text + " is a palindrome.");
        }else{
            System.out.println(text + " is not a palindrome.");
        }
    }

}

public class PalindromeString {
    public static void main(String[] args) {

        PalindromeChecker p1 = new PalindromeChecker("madam");
        p1.displayResult();

        PalindromeChecker p2 = new PalindromeChecker("hello");
        p2.displayResult();

    }
}
