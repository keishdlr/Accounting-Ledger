package com.pluralsight.Capstone;

import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    static Scanner Myscanner = new Scanner(System.in); //Scanner to let us read user input

    public static void main(String[] args) {
        //Create a loop that keeps the app running until the user chooses “X”

        //Display menu options:
        //D) Add Deposit
        //P) Make Payment
        //L) Ledger
        //X) Exit

        System.out.println("-----Home Screen-----");
        System.out.println("    D) Add Deposit   ");
        System.out.println("    P) Make Payment  ");
        System.out.println("    L) Ledger        ");
        System.out.println("    X) Exit          ");

        String selection = Myscanner.nextLine().toUpperCase();

        //Handle user input with a switch block. Using while to make a loop.
        while (true) {
            switch (selection) {
                case "D": // if d is selected then it will run add deposit method
                    break;
                case "P": // if p is selected then it will run make payment method
                    break;
                case "L": // if L is selected then it will run Ledger method and open the ledger screen
                    break;
                case "X": // if x is selected then it will exit the program
                default:
                    System.out.println("Invalid input. Try again");
            }
        }


    }
    // Call the methods:
    // addTransaction(true) for deposits [D]
    // ddTransaction(false) for payments [P] (Ternary Operator )

    public void addTransaction(boolean isDeposit){                  // In method addTransaction(boolean isDeposit) Prompt for
        System.out.println(" what is this deposit for? ");
        String description = Myscanner.nextLine();                  // - Description
        System.out.println(" WHo is the Vendor? ");
        String vendor = Myscanner.nextLine();                       //- Vendor
        System.out.println("What is the amount? ");
        Double amount = Double.parseDouble(Myscanner.nextLine());   //- Amount

    }


    // Convert amount to negative if isDeposit == false

    // Create a Transaction object with LocalDate.now() and LocalTime.now()

    // Call TransactionService.saveTransaction(transaction)

    //Print a confirmation message (add flair if you want!)
}







