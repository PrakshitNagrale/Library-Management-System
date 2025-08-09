package exceptions;

public class ExceptionHandler {


    public static void handleDuplicateIdException(DuplicateIdException duplicateIdException){
        System.out.println(duplicateIdException.getMessage());
    }


    public static  void handleMaxAttemptExceededException(MaxAttemptExceededException maxAttempt){
        System.out.println(maxAttempt.getMessage());
    }

    //to check list is empty
    public static  void handleEmptyListException(ListIsEmptyException emptyList){
        System.out.println(emptyList.getMessage());
    }

    public static void handleBookIssuedException(BookAlreadyIssuedException bookIssued) {
        System.out.println(bookIssued.getMessage());
    }

    public static void handleInvalidIdException(InvalidIdException invalidId) {

        System.out.println(invalidId.getMessage());
    }

    public static void hadleBookNotIssued(BookNotIssuedException bookNotIssued) {
        System.out.println(bookNotIssued.getMessage());
    }
}
