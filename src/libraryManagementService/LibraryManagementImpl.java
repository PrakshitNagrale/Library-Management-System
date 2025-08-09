package libraryManagementService;

import client.LibraryManagementClient;
import dto.BookIssuedByUserResponseDTO;
import dto.UserBookIssueResponseDTO;
import dto.UserBookReturnResponseDTO;
import exceptions.*;
import models.Book;
import models.BookStatusType;
import models.User;
import models.UserBook;
import util.ValidateInvalidInput;

import java.util.List;
import java.util.Scanner;

public class LibraryManagementImpl implements LibraryManagement{

    LibraryManagementClient libraryManagementClient;
    Scanner sc;

    public LibraryManagementImpl() {
        this.libraryManagementClient = new LibraryManagementClient();
        this.sc= new Scanner(System.in);

    }

    @Override
    public void addBook()throws DuplicateBookIdException,MaxAttemptExceededException{

        Book book = new Book();

        System.out.println("Please Enter Book Id: ");
        int id = ValidateInvalidInput.validateIntegerInput(sc.nextLine());//to validate Integer input throws exception if string

        libraryManagementClient.checkDuplicateBookId(id);//to check for duplicate id present or not and throw exception
        book.setId(id);//inserting id

        System.out.println("Please Enter Book Name");
        book.setName(ValidateInvalidInput.validateStringInput(sc.nextLine()));//to validate String Input whit retry
        System.out.println("Please Enter Author Name");
        book.setAuthorName(ValidateInvalidInput.validateStringInput(sc.nextLine()));
        book.setBookStatus(BookStatusType.AVAILABLE);


        Book book1 = libraryManagementClient.addBookDetails(book);//sending book details

        System.out.println("----Book Details Added Successfully!----");
        System.out.println(book1);
        System.out.println("----------------------------------------");

    }

    @Override
    public void addUser()throws DuplicateUserIdException ,MaxAttemptExceededException{

       User user = new User();

        System.out.println("Please Enter The User Id: ");
        int id = ValidateInvalidInput.validateIntegerInput(sc.nextLine());

        libraryManagementClient.checkDuplicateUserId(id); //throws exception if duplicate id exists
        user.setId(id);

        //taking inputs
        System.out.println("Please Enter The User Name: ");
        user.setName(ValidateInvalidInput.validateStringInput(sc.nextLine()));

        System.out.println("Please Enter The User Phone No.: ");
        user.setPhoneNo(ValidateInvalidInput.validateIntegerInput(sc.nextLine()));

        System.out.println("Please Enter The User Address: ");
        user.setAddress(ValidateInvalidInput.validateStringInput(sc.nextLine()));

        User user1 = libraryManagementClient.addUserDetails(user);//calling add method

        System.out.println("----User Details Added Successfully!----");
        System.out.println(user1);//printing user
        System.out.println("----------------------------------------");
    }

    @Override
    public void issueBook() throws BookListIsEmptyException,BookAlreadyIssuedException,InvalidUserIdException,InvalidBookIdException,MaxAttemptExceededException{

        libraryManagementClient.checkIsBookListEmpty();//check if book list is empty

        System.out.println("Please Enter User ID: ");
        int user_Id = ValidateInvalidInput.validateIntegerInput(sc.nextLine());//take user id

       User user = libraryManagementClient.checkUserIdExists(user_Id);//to check user exists or not

        System.out.println("Please Enter Book Id to Issue: ");
        int book_Id = ValidateInvalidInput.validateIntegerInput(sc.nextLine());//take book id

        libraryManagementClient.checkBookIdExists(book_Id);//to check book exists or not

        Book book = libraryManagementClient.checkBookAvailableToIssue(book_Id); //to check book is already issued or not

       UserBookIssueResponseDTO userBook =  libraryManagementClient.issueBook(user,book);//to issue book

        System.out.println("----Book Issued Successfully!----");
        System.out.println(userBook);                            //printing user book
        System.out.println("----------------------------------------");
    }


    @Override
    public void returnBook() throws UserBookListIsEmptyException,InvalidUserIdException,InvalidBookIdException,BookNotIssuedException,MaxAttemptExceededException{

        //1.check book  list is not empty
        //2.Ask for user id--> validate user id
        //3.ask for book id  == > validate book id
        //4.go and check the status of the book ==isSued

        //5. go in clint --> userbook-->userid ,bookid,issuedate is alrady set ,just change the bookstatus type,set return date.
        //6.create returnResponseDTO send all the detaiils along with issuedate.

        libraryManagementClient.checkIsUserBookListEmpty();//check data is present in user book list

//        libraryManagementClient.checkIsBookListEmpty();//check if book list is empty

        System.out.println("Please Enter User ID: ");
        int user_Id = ValidateInvalidInput.validateIntegerInput(sc.nextLine());//take user id

        User user = libraryManagementClient.checkUserIdExists(user_Id);//to check user exists or not

        System.out.println("Please Enter Book Id to Return: ");
        int book_Id = ValidateInvalidInput.validateIntegerInput(sc.nextLine());//take book id

        libraryManagementClient.checkBookIdExists(book_Id);//to check book exists or not

        UserBook userBook  = libraryManagementClient.checkBookAlreadyIssued(book_Id,user_Id);//to check this book is already issued so we can return theis book

        UserBookReturnResponseDTO userBookReturnDTO = libraryManagementClient.returnBook(userBook);

        System.out.println(userBookReturnDTO);


        System.out.println("----Book Returned Successfully!----");
        System.out.println(userBookReturnDTO);                     //printing user book
        System.out.println("----------------------------------------");




    }

    @Override
    public void viewAllBooks() throws BookListIsEmptyException {

        libraryManagementClient.checkIsBookListEmpty();//throws exception id book list is empty


       List<Book> bookList = libraryManagementClient.getAllBooks();

        //printing all books
        System.out.println("----Books Present In The Library----");

        for(Book book : bookList){ //iterating on the list to get all books
            System.out.println(book);
            System.out.println("-----------------------");

        }
    }

    @Override
    public void viewBooksBorrowedByUser()throws ListIsEmptyException,InvalidIdException,UserNotIssuedAnyBook{

        libraryManagementClient.checkIsUserBookListEmpty();//check data is present in user book list

        System.out.println("Please Enter User ID: ");
        int user_Id = ValidateInvalidInput.validateIntegerInput(sc.nextLine());//take user id

        libraryManagementClient.checkUserIdExists(user_Id);//to check user exists or not

        libraryManagementClient.checkUserExistsInUserBookList(user_Id);//to check user present in user book list


        List<BookIssuedByUserResponseDTO> userBooks = libraryManagementClient.viewAllBooksBorrowedByUser(user_Id);

        //printing all books of the particular user
        System.out.println("----Books Borrowed By User Id: "+user_Id+ "----");

       for(BookIssuedByUserResponseDTO userBook : userBooks){
           System.out.println(userBook);
           System.out.println("-----------------------");

       }



    }
}
