package exceptions;

public class ListIsEmptyException extends RuntimeException{

    public ListIsEmptyException(String message) {
        super(message);
    }
}
