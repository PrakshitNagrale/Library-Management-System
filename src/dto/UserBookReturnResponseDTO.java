package dto;

import models.UserBook;

import java.time.LocalDate;

public class UserBookReturnResponseDTO {

    private int userId;
    private int bookId;
    private String bookName;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return  "User Id: " + this.userId +
                "\nBookId: " + this.bookId +
                "\nBookName: " + this.bookName+
                "\nIssueDate: " + this.issueDate +
                "\nReturnDate: " + returnDate;
    }

    public static UserBookReturnResponseDTO convertFromUserBookToReturnDTO(UserBook userBook){

        UserBookReturnResponseDTO userBookReturnDTO = new UserBookReturnResponseDTO();

        userBookReturnDTO.setBookId(userBook.getBook().getId());
        userBookReturnDTO.setUserId(userBook.getUser().getId());
        userBookReturnDTO.setBookName(userBook.getBook().getName());
        userBookReturnDTO.setIssueDate(userBook.getIssueDate());
        userBookReturnDTO.setReturnDate(userBook.getReturnDate());

        return userBookReturnDTO;


    }
}
