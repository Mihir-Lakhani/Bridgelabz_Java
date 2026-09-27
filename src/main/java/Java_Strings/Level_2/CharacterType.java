import java.util.Scanner;

public class CharacterType {
    static String check(char ch) {
        char temp = ch;
        if (temp >= 'A' && temp <= 'Z') temp = (char) (temp + 32);

        if (temp == 'a' || temp == 'e' || temp == 'i'
                || temp == 'o' || temp == 'u') {
            return "Vowel";
        }

        if (temp >= 'a' && temp <= 'z') return "Consonant";
        return "Not a Letter";
    }

    static String[][] findTypes(String text) {
        String[][] data = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            data[i][0] = String.valueOf(text.charAt(i));
            data[i][1] = check(text.charAt(i));
        }
        return data;
    }

    static void show(String[][] data) {
        System.out.println("Character\tType");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        show(findTypes(text));
        sc.close();
    }
}