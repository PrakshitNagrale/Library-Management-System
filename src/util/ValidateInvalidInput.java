package util;

import exceptions.MaxAttemptExceededException;

import java.util.Scanner;

public class ValidateInvalidInput {

    Scanner sc;

    //method to validate proper integer input
    public static Integer validateIntegerInput(String input){

        int attempt=0;//initializing variable for max limit

        while(attempt<3){// a loop for retry limit

            try {
                return Integer.parseInt(input);//converting string input to integer and returning back

            }catch (NumberFormatException e ){//if the user put character then it will catch here
                System.out.println("Invalid Input! ");
                attempt = attempt+1;        //increment attempt

                if(attempt<3){
                    System.out.println("Please enter Numeric value ");
                    System.out.println("Try again:");
                    Scanner sc = new Scanner(System.in);
                    input = sc.nextLine();//taking input
                }
            }

        }

        //if the limit exceed throwing exception
        throw new MaxAttemptExceededException("Max Attempt Exceeded! Returing to Main Menu");

    }

    //to validate string input,it allows string with number
    public static String validateStringInput(String input){
        Scanner sc=new Scanner(System.in);

        int attempt =0; // initializing variable for max limit

        while(attempt<3){   // a loop for retry limit

            // input allow letters, numbers, and spaces and reject empty input
            if (!input.isEmpty() && input.matches("[a-zA-Z0-9 ]+")) {
                return input;
            }
            else {
                System.out.println("Invalid input!");
                attempt = attempt+1;

                if(attempt<3){
                    System.out.println("Please enter only letters, numbers, and spaces");
                    System.out.println("Try again!");
                    input = sc.nextLine();
                }
            }
        }

        throw new MaxAttemptExceededException("Max attempts exceeded! Returning to main menu.");

    }
}
