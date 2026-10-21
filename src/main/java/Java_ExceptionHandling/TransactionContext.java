package Java_ExceptionHandling;

public class TransactionContext {

    static void processTransaction(String transactionId) throws TransactionException {
        throw new TransactionException("Payment was declined");
    }

    static void processWithContext(String transactionId) throws TransactionException {
        try {
            processTransaction(transactionId);
        } catch (TransactionException e) {
            throw new TransactionException("Transaction " + transactionId + " failed: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        try {
            processWithContext("TX-1001");
        } catch (TransactionException e) {
            System.out.println(e.getMessage());
            System.out.println("Original cause: " + e.getCause().getMessage());
        }
    }
}

class TransactionException extends Exception {
    TransactionException(String message) {
        super(message);
    }

    TransactionException(String message, Throwable cause) {
        super(message, cause);
    }
}
