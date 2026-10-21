package Java_Regex;

public class CountCharacterTypes {

    public static void main(String[] args) {
        String text = "Java 17!";
        int uppercase = 0;
        int lowercase = 0;
        int digits = 0;
        int special = 0;

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (Character.isUpperCase(character)) {
                uppercase++;
            } else if (Character.isLowerCase(character)) {
                lowercase++;
            } else if (Character.isDigit(character)) {
                digits++;
            } else if (!Character.isWhitespace(character)) {
                special++;
            }
        }

        System.out.println("Uppercase letters: " + uppercase);
        System.out.println("Lowercase letters: " + lowercase);
        System.out.println("Digits: " + digits);
        System.out.println("Special characters: " + special);
    }
}
