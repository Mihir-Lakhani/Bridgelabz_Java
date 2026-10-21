package Java_ExceptionHandling;

public class TransactionExceptionTypes {

    static void processTransaction(String account, int amount)
            throws InsufficientFundsException, InvalidAccountException {
        if (!account.equals("A-100")) {
            throw new InvalidAccountException("Account does not exist");
        }
        if (amount > 500) {
            throw new InsufficientFundsException("Not enough balance");
        }
        System.out.println("Transaction successful");
    }

    static void processWithContext(String transactionId, String account, int amount)
            throws TransactionProcessingException {
        try {
            processTransaction(account, amount);
        } catch (InsufficientFundsException | InvalidAccountException e) {
            throw new TransactionProcessingException(
                    "Transaction " + transactionId + " failed: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        try {
            processWithContext("TX-2001", "A-100", 900);
        } catch (TransactionProcessingException e) {
            System.out.println(e.getMessage());
            System.out.println("Cause: " + e.getCause().getClass().getSimpleName());
        }
    }
}

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String message) {
        super(message);
    }
}

class InvalidAccountException extends Exception {
    InvalidAccountException(String message) {
        super(message);
    }
}

class TransactionProcessingException extends Exception {
    TransactionProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}
