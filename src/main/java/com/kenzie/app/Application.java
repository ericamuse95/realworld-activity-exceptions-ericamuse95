package com.kenzie.app;

import java.io.*;
import java.util.Scanner;


/*
 * Java Program picks a random lucky number or a fortune, but only if exceptions are handled
 */
public class Application {
    public static final String FORTUNE_FILENAME = "fortunes.txt";

    public static void main(String args[])  {
        //TODO: Wrap the main code in a try/catch statement

        //DO NOT MODIFY THIS BLOCK
        Scanner scan = new Scanner(System.in);
        String input;
        int numberInput = 0;
        boolean needInput = true;
        //END BLOCK

        //Read in user input - loop until user enters correct input
        while (needInput) {
            //TODO: wrap the code inside the while event loop with a try/catch block
            displayMenu();
            input = scan.nextLine();
            checkForEmptyString(input);
            numberInput = convertStringInput(input);
            if (numberInput > 0) {
                needInput = false;
            }
        }


        //DO NOT MODIFY THIS BLOCK
        //Check user input for valid number value
        isInputValid(numberInput);

        //Selects and displays fortune based on number found
        displayResult(numberInput);
        //END BLOCK
    }

    // TODO: throw correct exceptions in method signature
    private static void displayResult(int number)  {
        // display result
        switch (number) {
            case 1:
                System.out.print("Your lucky number is: ");
                System.out.println(pickRandomNumber());
                break;
            case 2:
                System.out.print("Your lucky fortune is: ");
                System.out.println(pickFortune(FORTUNE_FILENAME));
                break;
            case 3:
                System.out.println("Goodbye. Try your luck another time!");
                break;
            default:
                System.out.println("Input not recognized.");
                break;
        }
    }

    // this method throws an automatic exception
    public static int convertStringInput(String input){
        //TODO: Do not change anything in this method.
        // This code automatically throws an exception if a non-number value is converted.
        // Run the application and enter a non-numeric string to find out what exception to catch in main().
        //
        return Integer.parseInt(input);
    }

    // this method will be coded to throw a standard exception
    public static boolean isInputValid(int cleanNumber){
        // TODO: fill in this method; throw IllegalArgumentException if the number is invalid
        // otherwise return true

        return false;  //replace when writing method
    }
    
    // Use this method to throw a custom Exception of type CustomWhiteSpaceException
    // With message: "Invalid input: Empty string entered."
    public static void checkForEmptyString(String input){
        // TODO: fill in this method; throw CustomEmptyStringException if the input is empty string

    }


    public static void displayMenu() {
        System.out.println();
        System.out.println("*******Hello Fortune Hunter!*******");
        System.out.println();
        System.out.println("Enter a number between 1-3:");
        System.out.println("1. Generate your lucky number");
        System.out.println("2. Get your fortune");
        System.out.println("3. Exit program");
        System.out.println();
        System.out.print(">");

    }

    public static int pickRandomNumber() {
        int min = 1;
        int max = 10;

        // generate random int value from 50 to 100
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    public static String pickFortune(String filename) throws FileNotFoundException, IOException {
        int random_int = pickRandomNumber();

        // open the file
        FileInputStream fstream = new FileInputStream(filename);
        BufferedReader breader = new BufferedReader(new InputStreamReader(fstream));

        String strLine = "";

        // read File Line By Line
        for (int i = 1; i < random_int; i++) {
            strLine = breader.readLine();
        }

        // close the input stream
        fstream.close();
        return strLine;
    }
}

