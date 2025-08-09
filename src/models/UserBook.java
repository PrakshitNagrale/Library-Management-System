package models;

import java.time.LocalDate;

public class UserBook {

    private User user;
    private Book book;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
        return "UserBook{" +
                "user Id=" + user.getId() +
                ", book=" + book.getId()+
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
