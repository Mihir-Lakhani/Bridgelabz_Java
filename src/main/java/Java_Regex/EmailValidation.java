package Java_Regex;

public class EmailValidation {

    static boolean isValidEmail(String email) {
        String pattern = "[A-Za-z0-9]+([._+-][A-Za-z0-9]+)*@[A-Za-z0-9-]+\\.[A-Za-z]{2,}(\\.[A-Za-z]{2,})?";
        return email != null && email.matches(pattern);
    }

    public static void main(String[] args) {
        String[] emails = {
                "abc.xyz@bl.co.in",
                "abc-100@yahoo.com",
                "abc..2002@gmail.com",
                "abc@.com"
        };

        for (String email : emails) {
            System.out.println(email + " -> " + isValidEmail(email));
        }
    }
}

