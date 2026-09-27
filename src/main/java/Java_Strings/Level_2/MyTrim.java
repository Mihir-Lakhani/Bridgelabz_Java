import java.util.Scanner;

public class MyTrim {
    static int[] trimPoints(String text) {
        int start = 0;
        int end = text.length();

        while (start < end && text.charAt(start) == ' ') start++;
        while (end > start && text.charAt(end - 1) == ' ') end--;

        return new int[]{start, end};
    }

    static String makeSub(String text, int start, int end) {
        String ans = "";
        for (int i = start; i < end; i++) {
            ans += text.charAt(i);
        }
        return ans;
    }

    static boolean same(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String text = sc.nextLine();

        int[] p = trimPoints(text);
        String myResult = makeSub(text, p[0], p[1]);
        String builtInResult = text.trim();

        System.out.println("My result: " + myResult);
        System.out.println("Built-in result: " + builtInResult);
        System.out.println("Both are same: " +
                same(myResult, builtInResult));
        sc.close();
    }
}