package Java_ExceptionHandling;

public class ResourceCleanup {

    static class SimpleConnection implements AutoCloseable {
        SimpleConnection() {
            System.out.println("Connection opened");
        }

        void runTask() {
            System.out.println("Task started");
            throw new RuntimeException("Task failed");
        }

        @Override
        public void close() {
            System.out.println("Connection closed");
        }
    }

    public static void main(String[] args) {
        try (SimpleConnection connection = new SimpleConnection()) {
            connection.runTask();
        } catch (RuntimeException e) {
            System.out.println("Handled: " + e.getMessage());
        }
    }
}
