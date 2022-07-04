package com.kenzie.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;


/*
 * Java Program picks a random lucky number or a fortune, but only if exceptions are handled
 */
public class Main {
    public static final String FORTUNE_FILENAME = "fortunes.txt";

    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        String input;
        int number = 0;
        // do not modify code above this line

        do{
            // TODO: wrap the code inside the do-while loop with a try/catch block
            displayMenu();
            input = scan.nextLine();
            number = processInput(input);
        } while (number == 0);

        // do not modify the code in main() below this line
        try{
            isValid(number);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        displayResult(number);
    }

    // TODO: throw correct exception in method signature
    private static void displayResult(int number) {
        // display result
        switch (number) {
            case 1:
                System.out.print("Your lucky number is: ");
                System.out.println(pickRandom());
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

    // only turn the input from a String into an int
    public static int processInput(String input){
        // TODO: fill in the method; experiment with invalid input to decide which exception to use
        return 0;
    }

    public static boolean isValid(int cleanNumber){
        // TODO: fill in this method; throw IllegalArgumentException if the number is invalid
        // otherwise return true
       return false;
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

    public static int pickRandom() {
        int min = 1;
        int max = 10;

        // generate random int value from 50 to 100
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    public static String pickFortune(String filename) throws FileNotFoundException, IOException {
        int random_int = pickRandom();

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
