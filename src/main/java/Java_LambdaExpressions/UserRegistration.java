package Java_LambdaExpressions;

import java.util.Scanner;
import java.util.function.Predicate;

// UC13: lambda validators using the name/email/mobile/password rules from UC1-UC8.
public class UserRegistration {

    static final Predicate<String> FIRST_NAME = value -> value != null
            && value.matches("[A-Z][a-zA-Z]{2,}");
    static final Predicate<String> LAST_NAME = value -> FIRST_NAME.test(value);

    // Classroom email shape: abc[.xyz]@bl.co[.in], not a full internet email parser.
    static final Predicate<String> EMAIL = value -> value != null && value.matches(
            "[A-Za-z0-9]+(?:\\.[A-Za-z0-9]+)?@[A-Za-z0-9]+"
            + "\\.[A-Za-z]{2,}(?:\\.[A-Za-z]{2,})?");
    static final Predicate<String> MOBILE = value -> value != null
            && value.matches("[1-9][0-9]* [0-9]{10}");

    // At least 8 characters, one uppercase, one digit, exactly one special character.
    // Demo policy: printable ASCII only, with no whitespace. Lowercase is not mandatory.
    static final Predicate<String> PASSWORD = value -> value != null && value.length() >= 8
            && value.chars().allMatch(c -> c >= 33 && c <= 126)
            && value.chars().anyMatch(c -> c >= 'A' && c <= 'Z')
            && value.chars().anyMatch(c -> c >= '0' && c <= '9')
            && value.chars().filter(c -> !Character.isLetterOrDigit(c)).count() == 1;

    static boolean validate(String first, String last, String email, String mobile, String password) {
        boolean firstValid = FIRST_NAME.test(first);
        boolean lastValid = LAST_NAME.test(last);
        boolean emailValid = EMAIL.test(email);
        boolean mobileValid = MOBILE.test(mobile);
        boolean passwordValid = PASSWORD.test(password);
        System.out.println("First name valid: " + firstValid);
        System.out.println("Last name valid: " + lastValid);
        System.out.println("Email valid: " + emailValid);
        System.out.println("Mobile valid: " + mobileValid);
        System.out.println("Password valid: " + passwordValid);
        return firstValid && lastValid && emailValid && mobileValid && passwordValid;
    }

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--interactive")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("First name:");
            String first = scanner.nextLine();
            System.out.println("Last name:");
            String last = scanner.nextLine();
            System.out.println("Email:");
            String email = scanner.nextLine();
            System.out.println("Mobile (country code, space, 10 digits):");
            String mobile = scanner.nextLine();
            System.out.println("Password:");
            String password = scanner.nextLine();
            System.out.println("Registration valid: " + validate(first, last, email, mobile, password));
        } else {
            System.out.println("Valid registration:");
            validate("Mihir", "Lakhani", "abc.xyz@bl.co.in", "91 9919819801", "Abcdef1!");
            System.out.println("Invalid registration:");
            validate("mi", "la", "abc@@bl.co", "9919819801", "Abcdef1!!");
            System.out.println("Use --interactive to enter your own registration.");
        }
    }
}
