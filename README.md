- The **Library Management System** is a Java-based console application designed to manage books and users in a library.  
- It supports **adding books**, **registering users**, **issuing books**, **returning books**, and **viewing available/borrowed books**.  
- The project follows a modular design with **custom exception handling** to ensure smooth user experience.

** Features -
- Add Books – Store book details with unique IDs.
- Add Users – Register new library users.
- Issue Books – Allow users to borrow available books.
- Return Books – Handle returning of borrowed books.
- View All Books – List all books in the library.
- View Books Borrowed by a User – Track which books a user has issued.
- Exception Handling – Handles invalid inputs, duplicate IDs, empty lists, and max attempt limits gracefully.

**  Technologies Used
- Java – Core language for development
- OOP Concepts – Classes, interfaces, encapsulation
- Custom Exceptions – For better error handling
- Scanner – For user input
 
** Usage
- The program will display a menu (1-7).

- Enter the number corresponding to the desired operation.

**  Example:

1. Add Book
2. Add User
3. Issue Book
4. Return Book
5. View All Books
6. View Books Borrowed By User
7. Exit

- Add a book → Enter book ID, title, author.

- Add a user → Enter user ID and name.

- Issue the book → Enter book ID and user ID.

- Return the book → Enter book ID.

- View all books → Displays list with availability status.

** Exception Handling-

- The system includes multiple custom exceptions:

- MaxAttemptExceededException – Prevents repeated invalid attempts.

- DuplicateIdException – Stops duplicate book/user entries.

- InvalidIdException – Handles incorrect book/user IDs.

- BookAlreadyIssuedException – Prevents issuing the same book twice.

- BookNotIssuedException – Prevents returning books that were never issued.

- ListIsEmptyException – Handles cases when no books/users are available.

- UserNotIssuedAnyBook – Alerts if a user has no borrowed books.


** Example Output-

----------------------------------------------------
        **** LIBRARY MANAGEMENT SYSTEM ****
----------------------------------------------------
1. Add Book
2. Add User
3. Issue Book
4. Return Book
5. View All Books
6. View Books Borrowed By User
7. Exit
   
- Please choose an option to perform (1-7)
   1
 - Please Enter Book Id:
   1
- Please Enter Book Name: Harry Potter 
- Please Enter Author Name: J K Rowling

   ----Book Details Added Successfully!----

- Book Id: 1
- Book Name: Harry Potter
- Book Author Name: J K Rowling 
- Book Status: AVAILABLE
----------------------------------------
1. Add Book
2. Add User
3. Issue Book
4. Return Book
5. View All Books
6. View Books Borrowed By User
7. Exit
   
- Please choose an option to perform (1-7)
   2 
- Please Enter The User Id:
   1 
- Please Enter The User Name:
   Akash 
- Please Enter The User Phone No.:
   8899989 
- Please Enter The User Address:
   Nagpur 
- ----User Details Added Successfully!---- 
- User Id: 1 
- User Name: Akash 
- PhoneNo: 8899989 
- Address: Nagpur
----------------------------------------
1. Add Book
2. Add User
3. Issue Book
4. Return Book
5. View All Books
6. View Books Borrowed By User
7. Exit

- Please choose an option to perform (1-7)
   3 
- Please Enter User ID:
   1 
- Please Enter Book Id to Issue:
   1 
- ----Book Issued Successfully!---- 
- User Id: 1 
- Book Id: 1 
- Book Name: Harry Potter 
- Book Status: ISSUED 
- Issue Date: 2025-08-10
- ----------------------------------------







