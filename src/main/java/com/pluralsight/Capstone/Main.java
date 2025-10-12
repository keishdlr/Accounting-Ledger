package com.pluralsight.Capstone;

import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    Scanner Myscanner = new Scanner(System.in); //Scanner to let us read user input

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
                case "D":
                    break;
                case "P":
                    break;
                case "L":
                    break;
                case "X":
                default:
                    System.out.println("Invalid input. Try again");
            }
        }


    }
    // Call addTransaction(true) for deposits and addTransaction(false) for payments

    // In addTransaction(boolean isDeposit)

    // Prompt for:
    //- Description
    //- Vendor
    //- Amount

    // Convert amount to negative if isDeposit == false

    // Create a Transaction object with LocalDate.now() and LocalTime.now()

    // Call TransactionService.saveTransaction(transaction)

    //Print a confirmation message (add flair if you want!)
}







