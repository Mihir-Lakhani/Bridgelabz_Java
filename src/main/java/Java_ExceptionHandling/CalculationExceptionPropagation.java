package Java_ExceptionHandling;

public class CalculationExceptionPropagation {

    static int divide(int numerator, int denominator) throws CalculationException {
        if (denominator == 0) {
            throw new CalculationException("Denominator cannot be zero");
        }
        return numerator / denominator;
    }

    static int calculateResult(int numerator, int denominator) throws CalculationException {
        return divide(numerator, denominator);
    }

    public static void main(String[] args) {
        try {
            System.out.println(calculateResult(20, 0));
        } catch (CalculationException e) {
            System.out.println("Calculation failed: " + e.getMessage());
        }
    }
}

class CalculationException extends Exception {
    CalculationException(String message) {
        super(message);
    }
}
