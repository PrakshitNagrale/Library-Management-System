package exceptions;

public class BookListIsEmptyException extends ListIsEmptyException {
    public BookListIsEmptyException(String message) {
        super(message);
    }
}
