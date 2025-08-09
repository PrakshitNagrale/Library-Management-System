package exceptions;

public class UserNotIssuedAnyBook extends RuntimeException {
    public UserNotIssuedAnyBook(String message) {
        super(message);
    }
}

