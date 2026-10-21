package Java_ExceptionHandling;

import java.io.IOException;

public class CheckedUncheckedExceptions {

    static int processData(String text) throws IOException {
        if (text == null || text.isEmpty()) {
            throw new IOException("Input data is missing");
        }
        int number = Integer.parseInt(text);
        return 100 / number;
    }

    public static void main(String[] args) {
        String[] inputs = {"5", "0", "hello", ""};

        for (String input : inputs) {
            try {
                System.out.println(input + " -> " + processData(input));
            } catch (IOException e) {
                System.out.println("Checked exception: " + e.getMessage());
            } catch (NumberFormatException | ArithmeticException e) {
                System.out.println("Unchecked exception: " + e.getMessage());
            }
        }
    }
}
