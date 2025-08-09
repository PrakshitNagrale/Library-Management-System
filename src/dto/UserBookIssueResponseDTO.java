package dto;

import models.BookStatusType;
import models.UserBook;

import java.time.LocalDate;

public class UserBookIssueResponseDTO {

    private int userId;
    private int bookId;
    private String bookName;
    private BookStatusType bookStatusType;
    private LocalDate issueDate;


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

    public BookStatusType getBookStatusType() {
        return bookStatusType;
    }

    public void setBookStatusType(BookStatusType bookStatusType) {
        this.bookStatusType = bookStatusType;
    }

    @Override
    public String toString(){

        return "User Id: "+this.userId+
                "\nBook Id: "+this.bookId+
                "\nBook Name: "+this.bookName+
                "\nBook Status: "+this.bookStatusType+
                "\nIssue Date: "+this.issueDate;

    }


    public static UserBookIssueResponseDTO convertFromUserBookToIssueDTO(UserBook userBook){

        UserBookIssueResponseDTO userBookIssueDTO = new UserBookIssueResponseDTO();

        userBookIssueDTO.setBookId(userBook.getBook().getId());
        userBookIssueDTO.setUserId(userBook.getUser().getId());
        userBookIssueDTO.setBookName(userBook.getBook().getName());
        userBookIssueDTO.setBookStatusType(userBook.getBook().getBookStatus());
        userBookIssueDTO.setIssueDate(userBook.getIssueDate());

        return userBookIssueDTO;
    }
}
