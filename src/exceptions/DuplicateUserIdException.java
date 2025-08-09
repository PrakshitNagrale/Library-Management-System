package exceptions;

public class DuplicateUserIdException extends DuplicateIdException{

    public DuplicateUserIdException(String message) {
        super(message);
    }
}
