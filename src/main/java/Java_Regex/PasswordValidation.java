package Java_Regex;

public class PasswordValidation {

    static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8 || password.matches(".*\\s+.*")) {
            return false;
        }

        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        int specialCharacters = 0;

        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            if (!Character.isLetterOrDigit(character)) {
                specialCharacters++;
            }
        }

        return hasUppercase && hasDigit && specialCharacters == 1;
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Mango123!"));
        System.out.println(isValidPassword("mango123"));
        System.out.println(isValidPassword("Mango123!!"));
    }
}

