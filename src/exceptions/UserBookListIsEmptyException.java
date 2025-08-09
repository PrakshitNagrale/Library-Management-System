package exceptions;

public class UserBookListIsEmptyException extends ListIsEmptyException {

    public UserBookListIsEmptyException(String message) {
        super(message);
    }
}
