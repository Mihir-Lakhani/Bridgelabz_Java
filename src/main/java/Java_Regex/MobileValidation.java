package Java_Regex;

public class MobileValidation {

    static boolean isValidMobile(String mobile) {
        return mobile != null && mobile.matches("[0-9]{1,3} [0-9]{10}");
    }

    public static void main(String[] args) {
        System.out.println(isValidMobile("91 9919819801"));
        System.out.println(isValidMobile("9919819801"));
    }
}
