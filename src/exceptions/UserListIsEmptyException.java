package exceptions;

public class UserListIsEmptyException extends ListIsEmptyException {
    public UserListIsEmptyException(String message) {
        super(message);
    }
}
