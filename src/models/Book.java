package models;

public class Book {

    private int id;
    private String name;
    private String authorName;
    private BookStatusType bookStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public BookStatusType getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatusType bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString(){

        return "Book Id: "+id+
                "\nBook Name: "+ this.name+
                "\nBook Author Name: "+this.authorName+
                "\nBook Status: "+this.bookStatus;
    }
}
