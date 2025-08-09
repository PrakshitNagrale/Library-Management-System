package client;

import dto.BookIssuedByUserResponseDTO;
import dto.UserBookIssueResponseDTO;
import dto.UserBookReturnResponseDTO;
import exceptions.*;
import exceptions.InvalidUserIdException;
import models.Book;
import models.BookStatusType;
import models.User;
import models.UserBook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementClient {

    List<Book> bookList;
    List<User> userList;
    HashMap<Integer ,Book>  bookMap;
    HashMap<Integer,User> userMap;
    List<UserBook> userBooksList;
    HashMap<Integer,UserBook> userBookMap;

    Scanner sc;

    public LibraryManagementClient() {
        this.sc = new Scanner(System.in);
        this.userMap = new HashMap<>();
        this.bookMap = new HashMap<>();
        this.userList = new ArrayList<>();
        this.bookList = new ArrayList<>();
        this.userBooksList = new ArrayList<>();

    }


    public Book addBookDetails(Book book){

        bookList.add(book);//adding book in list
        bookMap.put(book.getId(),book);//adding book in hashmap for faster searching

        return book;
    }

    public List<Book> getAllBooks() {

        return bookList;
    }

    public User addUserDetails(User user) {

        userList.add(user);//adding in list
        userMap.put(user.getId(),user); // adding in map

        return user;
    }


    public UserBookIssueResponseDTO issueBook(User user, Book book) {

        UserBook userBook = new UserBook();

        userBook.setBook(book);
        userBook.setUser(user);
        userBook.setIssueDate(LocalDate.now());

        book.setBookStatus(BookStatusType.ISSUED);

        userBooksList.add(userBook);//adding to user book list
//        userBookMap.put(user.getId(),userBook);//to add in user book map

        bookMap.put(book.getId(), book);//updating in book map after changing book status

        UserBookIssueResponseDTO userBookIssueResponse = UserBookIssueResponseDTO.convertFromUserBookToIssueDTO(userBook);

        return userBookIssueResponse;
    }

    public void checkDuplicateBookId(int id) {

        if(bookMap.containsKey(id)){
            throw new DuplicateBookIdException("Id Already Present! Please Enter different Id");
        }
    }


    public void checkIsBookListEmpty() {

        if(bookList.isEmpty()){
            throw  new BookListIsEmptyException("No Data Present! Please add Book First!");
        }
    }

    public void checkDuplicateUserId(int id) {

        if(userMap.containsKey(id)){
            throw new DuplicateUserIdException("Id Already Present! Please Enter different Id");
        }
    }


    public Book checkBookAvailableToIssue(int id) {

       Book book =  bookMap.get(id);

       if(book.getBookStatus() == BookStatusType.AVAILABLE){//if available return  book
           return book;
       }
        throw new BookAlreadyIssuedException("This Book is "+book.getBookStatus() + "! Please Select Different Book! ");
    }


    public User checkUserIdExists(int id) {

        if(!userMap.containsKey(id)){
            throw new InvalidUserIdException("Invalid User Id! Please add valid User Id!");
        }
        else{
            return userMap.get(id);
        }

    }


    //to check book is present or not
    public void checkBookIdExists(int bookId) {


        if(!bookMap.containsKey(bookId)){
            throw  new InvalidBookIdException("Invalid Book Id! Please add valid Book Id!");
        }
    }

    public UserBook checkBookAlreadyIssued(int bookId,int userId) {


        boolean bookFound = false;  //iterating on the user book list to check user id issued book is equal to the input book id
        UserBook userBook= null;

        for(UserBook userBook1 : userBooksList){
            if(userBook1.getUser().getId()  == userId){
               if( userBook1.getBook().getId() == bookId){
                   bookFound = true;
                   userBook = userBook1;
                   break;
               }
            }
        }


       Book book =  bookMap.get(bookId);

        if(book.getBookStatus() == BookStatusType.ISSUED && bookFound){
            return userBook;
        }
         throw new BookNotIssuedException("This Book is Not Issued by UserId: "+userId+"! Please insert Valid Book Id To Return");
    }

    public UserBookReturnResponseDTO returnBook(UserBook userBook) {


        userBook.getBook().setBookStatus(BookStatusType.AVAILABLE);//changing status to  AVAILABLE
        bookMap.put(userBook.getBook().getId(),userBook.getBook());//updating book in book map

        userBook.setReturnDate(LocalDate.now());//setting return date
                //converting to response dto
        UserBookReturnResponseDTO userBookReturnDTO = UserBookReturnResponseDTO.convertFromUserBookToReturnDTO(userBook);

        userBooksList.remove(userBook);
        return userBookReturnDTO;//returning dto
    }

    public List<BookIssuedByUserResponseDTO> viewAllBooksBorrowedByUser(int userId) {

        List<BookIssuedByUserResponseDTO> bookIssuedByUserResponse = new ArrayList<>();//created new list

         for(UserBook userBook : userBooksList){ //iterating on user book list, to get data of particular user has currently issued books

            if(userBook.getUser().getId() == userId && userBook.getBook().getBookStatus() == BookStatusType.ISSUED){

                bookIssuedByUserResponse.add(BookIssuedByUserResponseDTO.convertFromUserBookToUserBookResponse(userBook));//converting to response dto and adding to list

            }
        }

        return bookIssuedByUserResponse; //return response dto list
    }

    public void checkIsUserBookListEmpty() {

        if(userBooksList.isEmpty()){
            throw new UserBookListIsEmptyException("No User has Issued Any Books till Now!");
        }
    }

    public void checkUserExistsInUserBookList(int userId){

        for(UserBook userBook : userBooksList){

            if(userBook.getUser().getId() == userId && userBook.getBook().getBookStatus() == BookStatusType.ISSUED){

                return;

            }
        }
        throw  new UserNotIssuedAnyBook("User Id: "+userId+" has not Issued any Book!");
    }



}
