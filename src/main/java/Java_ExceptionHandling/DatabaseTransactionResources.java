package Java_ExceptionHandling;

public class DatabaseTransactionResources {

    static class DatabaseConnection implements AutoCloseable {
        DatabaseConnection() {
            System.out.println("Database connection opened");
        }

        @Override
        public void close() {
            System.out.println("Database connection closed");
        }
    }

    static class DatabaseTransaction implements AutoCloseable {
        DatabaseTransaction() {
            System.out.println("Transaction started");
        }

        @Override
        public void close() {
            System.out.println("Transaction ended");
        }
    }

    public static void main(String[] args) {
        try (DatabaseConnection connection = new DatabaseConnection();
             DatabaseTransaction transaction = new DatabaseTransaction()) {
            System.out.println("Updating account balance");
            throw new RuntimeException("Update failed");
        } catch (RuntimeException e) {
            System.out.println("Handled: " + e.getMessage());
        }
    }
}
