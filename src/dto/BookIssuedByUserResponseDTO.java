package dto;

import models.UserBook;

import java.time.LocalDate;

public class BookIssuedByUserResponseDTO {

    private int userId;
    private String userName;
    private int bookId;
    private String BookName;
    private LocalDate issueDate;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "userId: "+this.userId +
                "\nUserName: "+this.userName+
                "\nBookId: " + this.bookId+
                "\nBookName: " + this.BookName+
                "\nIssueDate: " + this.issueDate;

    }

    public  static  BookIssuedByUserResponseDTO convertFromUserBookToUserBookResponse(UserBook userBook){

        BookIssuedByUserResponseDTO bookIssuedByUserResponse = new BookIssuedByUserResponseDTO();

        bookIssuedByUserResponse.setUserId(userBook.getUser().getId());
        bookIssuedByUserResponse.setUserName(userBook.getUser().getName());
        bookIssuedByUserResponse.setBookId(userBook.getBook().getId());
        bookIssuedByUserResponse.setBookName(userBook.getBook().getName());
        bookIssuedByUserResponse.setIssueDate(userBook.getIssueDate());

        return bookIssuedByUserResponse;
    }
}
