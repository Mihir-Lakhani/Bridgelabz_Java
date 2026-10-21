package Java_ExceptionHandling;

public class DivisionRethrow {

    static int performDivision(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return numerator / denominator;
    }

    static int calculate(int numerator, int denominator) {
        try {
            return performDivision(numerator, denominator);
        } catch (ArithmeticException e) {
            ArithmeticException error = new ArithmeticException("Division calculation failed");
            error.initCause(e);
            throw error;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(calculate(10, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("Reason: " + e.getCause().getMessage());
        }
    }
}
