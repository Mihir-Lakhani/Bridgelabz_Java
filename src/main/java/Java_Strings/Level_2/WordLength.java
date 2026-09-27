package Java_Strings.Level_2;

import java.util.Scanner;

public class WordLength {
    static int getLen(String s) {
        int n = 0;
        try {
            while (true) {
                s.charAt(n);
                n++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return n;
    }

    static String[] mySplit(String s) {
        int spaces = 0;
        for (int i = 0; i < getLen(s); i++) {
            if (s.charAt(i) == ' ') spaces++;
        }

        String[] words = new String[spaces + 1];
        int k = 0;
        String word = "";

        for (int i = 0; i < getLen(s); i++) {
            if (s.charAt(i) == ' ') {
                words[k++] = word;
                word = "";
            } else {
                word += s.charAt(i);
            }
        }
        words[k] = word;
        return words;
    }

    static String[][] makeTable(String[] words) {
        String[][] data = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            data[i][1] = String.valueOf(getLen(words[i]));
        }
        return data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] data = makeTable(mySplit(text));

        System.out.println("Word\tLength");
        for (int i = 0; i < data.length; i++) {
            int len = Integer.parseInt(data[i][1]);
            System.out.println(data[i][0] + "\t" + len);
        }
        sc.close();
    }
}