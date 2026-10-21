package Java_ExceptionHandling;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> users = new ArrayList<>();

    static void registerUser(String username) throws UserAlreadyExistsException {
        if (users.contains(username)) {
            throw new UserAlreadyExistsException("User already exists: " + username);
        }
        users.add(username);
        System.out.println("Registered: " + username);
    }

    static boolean checkUserExistence(String username) throws UserNotFoundException {
        if (users.contains(username)) {
            return true;
        }
        throw new UserNotFoundException("User was not found: " + username);
    }

    public static void main(String[] args) {
        try {
            registerUser("Mihir");
            registerUser("Rishika");
            registerUser("Mihir");
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Mihir exists: " + checkUserExistence("Mihir"));
            checkUserExistence("Unknown");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

class UserNotFoundException extends Exception {
    UserNotFoundException(String message) {
        super(message);
    }
}

class UserAlreadyExistsException extends Exception {
    UserAlreadyExistsException(String message) {
        super(message);
    }
}
