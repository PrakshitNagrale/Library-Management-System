package librarymanagementApp;

import exceptions.*;
import libraryManagementService.LibraryManagement;
import libraryManagementService.LibraryManagementImpl;




import java.util.Scanner;

public class LibraryManagementApp {

    Scanner sc;
    LibraryManagement libraryManagement;

    public LibraryManagementApp() {

        sc = new Scanner(System.in);
        libraryManagement = new LibraryManagementImpl();
    }

    public void startLibraryManagementSystem(){




        System.out.println("----------------------------------------------------");
        System.out.println("        **** LIBRARY MANAGEMENT SYSTEM ****");
        System.out.println("----------------------------------------------------");



        boolean keepRunning = true; //initialize true to keep runing the system

        while(keepRunning){


            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. View Books Borrowed By User");
            System.out.println("7. Exit");

            try {

                System.out.println("Please choose an option to perform (1-7)");
                String input = sc.nextLine();//reading full line to avoid input mismatch exception,if user enter character in place of numbers
                int option = Integer.parseInt(input); //converting to int


                switch (option) {

                    case 1:
                        try {
                            libraryManagement.addBook(); //to add book

                        }catch (MaxAttemptExceededException | DuplicateIdException exception){
                            System.out.println(exception.getMessage());
                        }
                        break;

                    case 2:
                        try{
                            libraryManagement.addUser(); //to add user

                        }catch (DuplicateIdException | MaxAttemptExceededException exception){
                            System.out.println(exception.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            libraryManagement.issueBook(); //to issue book

                        }catch (ListIsEmptyException | BookAlreadyIssuedException | InvalidIdException |MaxAttemptExceededException exception){
                            System.out.println(exception.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            libraryManagement.returnBook(); //to return book

                        }catch (ListIsEmptyException | InvalidIdException | BookNotIssuedException |MaxAttemptExceededException exception){
                            System.out.println(exception.getMessage());
                        }
                        break;

                    case 5:
                        try {
                              libraryManagement.viewAllBooks(); //to view all books present in library

                        }catch (ListIsEmptyException emptyList){
                            System.out.println(emptyList.getMessage());
                        }
                        break;
                    case 6:
                        try {
                            libraryManagement.viewBooksBorrowedByUser();

                        }catch (ListIsEmptyException | InvalidIdException | UserNotIssuedAnyBook exception){
                            System.out.println(exception.getMessage());
                        }
                        break;

                    case 7:
                        System.out.println("----------------------------------------------------");
                        System.out.println("**** Library Management System Terminated ****");
                        System.out.println("----------------------------------------------------");
                        keepRunning = false;
                        break;

                    default:
                        System.out.println("----Invalid Input! Please try again!----");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid Input!. Please enter a valid number (1-7)");
                System.out.println("----------------------------------------------------");

            }




        }

    }
}
