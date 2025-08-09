package libraryManagementService;

import models.Book;

import java.util.List;

public interface LibraryManagement {

    public void addBook();
    public void addUser();
    public void issueBook();
    public void returnBook();
    public void viewAllBooks();
    public void viewBooksBorrowedByUser();
}
