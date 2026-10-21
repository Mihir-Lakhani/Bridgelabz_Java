package Java_ExceptionHandling;

public class WrapUnwrapException {

    static void readNumber() throws DataProcessingException {
        try {
            Integer.parseInt("not-a-number");
        } catch (NumberFormatException e) {
            throw new DataProcessingException("Could not read the number", e);
        }
    }

    public static void main(String[] args) {
        try {
            readNumber();
        } catch (DataProcessingException e) {
            System.out.println(e.getMessage());
            System.out.println("Original error: " + e.getCause().getClass().getSimpleName());
        }
    }
}

class DataProcessingException extends Exception {
    DataProcessingException(String message, Throwable cause) {

        super(message, cause);

    }
}
