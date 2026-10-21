package Java_ExceptionHandling;

public class Exception1 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30};

        try {
            System.out.println(numbers[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("That position does not exist in the array.");
        } finally {
            System.out.println("Program finished.");
        }
    }
}
