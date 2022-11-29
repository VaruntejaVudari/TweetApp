package com.cts.tweet;
import java.util.Scanner;

import javax.annotation.Resource;

public class Tweet {
	
	@Resource
	public TweetService tweetService; 
	
    Alphabet alphabet;
    public static Scanner keyboard;

    public Tweet(Scanner scanner) {
        keyboard = scanner;
    }

    public Tweet(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
    }

    public void mainLoop() {
        System.out.println("Welcome to Tweet App Services :)");
        printMenu();

        String userOption = "-1";

        while (!userOption.equals("4")) {

            userOption = keyboard.next();

            switch (userOption) {
                case "1": {
                	requestRegistration();
                    printMenu();
                }
                case "2": {
                    requestLogin();
                    printMenu();
                }
                case "3": {
                    printUsefulInfo();
                    printMenu();
                }
                case "4": {
                    printUsefulInfo();
                    printMenu();
                }
                case "5": {
                    printUsefulInfo();
                    printMenu();
                }
                case "6": printQuitMessage();
                default: {
                    System.out.println();
                    System.out.println("Kindly select one of the available commands");
                    printMenu();
                }
            }
        }
    }

    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }

    private void requestRegistration() {
        boolean Registration = false;
        boolean firstname = false;
        boolean emailId = false;
        boolean Password = false;
        
        boolean correctParams = false;

        System.out.println();
        System.out.println("Hello, welcome to the Tweet App :) answer"
                + " the following questions by Yes or No \n");

        do {
            System.out.println("Do you want Register to Tweet App");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            sc.close();
            //if (isInclude(input)) Registration = true;
            if (input.equalsIgnoreCase("yes")) {
            	Registration = true;
            } else {
                if (!input.equalsIgnoreCase("no")) {
                    PasswordRequestError();
                }
                Registration = false;
            }
            //No Pool Selected
            if (!Registration) {
                System.out.println("You have selected no characters to register your " +
                        "tweet at least one of your answers should be Yes");
                correctParams = true;
                firstname = true;
            }

            if (!firstname) {
            	System.out.println("Great! Now enter the First Name of the Registration");
                String firstName = keyboard.nextLine();

                if (firstName == null || firstName.isEmpty()) {
                    System.out.println("First Name should not be empty/null");
                    correctParams = true;
                    emailId = true;
                }
            } else {
            	emailId = true;
            }
            
            if (!emailId) {
            	System.out.println("Great! Now enter the email of the Registration");
                String email = keyboard.nextLine();

                if (email == null || email.isEmpty()) {
                    System.out.println("Email should not be empty/null");
                    correctParams = true;
                    Password = true;
                }
            } else {
            	Password = true;
            }
            
            if (!Password) {
            	System.out.println("Great! Now enter the password of the Registration");
                String password = keyboard.nextLine();

                if (password == null || password.isEmpty()) {
                    System.out.println("Password should not be empty/null");
                    correctParams = true;
                }
            }
            
            //final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
            //final Password password = generator.GeneratePassword(length);

            //System.err.println("Your generated password -> " + password);

        } while (correctParams);
    }

    private boolean isInclude(String Input) {
        if (Input.equalsIgnoreCase("yes")) {
            return true;
        } else {
            if (!Input.equalsIgnoreCase("no")) {
                PasswordRequestError();
            }
            return false;
        }
    }

    private void PasswordRequestError() {
        System.out.println("You have entered something incorrect let's go over it again \n");
    }

    private void requestLogin() {
        String input;
        final Scanner in = new Scanner(System.in);

        System.out.print("\nEnter your password:");
        input = in.nextLine();

        //final Password p = new Password(input);
        //System.out.println(p.calculateScore());

        in.close();
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - User registration and login");
        System.out.println("Enter 2 - Post tweet");
        System.out.println("Enter 3 - View all tweets (all from logged in users account)");
        System.out.println("Enter 4 - View users and their respective tweets");
        System.out.println("Enter 5 - Forgot passwords option to reset password");
        System.out.println("Enter 6 - Quit");
        System.out.print("Choice:");
    }

    private void printQuitMessage() {
        System.out.println("Closing the program bye bye!");
    }
}
