package com.pluralsight.Capstone;

import java.util.List;
import java.util.Scanner;

import static java.lang.Double.*;

public class Main {
    static Scanner Myscanner = new Scanner(System.in); //Scanner to let us read user input

    public static void main(String[] args) {
        //Create a loop that keeps the app running until the user chooses “X”

        //Display menu options:

        System.out.println("--💸---Home Screen---💸--");
        System.out.println("    D) Add Deposit   ");
        System.out.println("    P) Make Payment  ");
        System.out.println("    L) Ledger        ");
        System.out.println("    X) Exit          ");

        String selection = Myscanner.nextLine().toUpperCase();

        //Handle user input with a switch block. Using while to make a loop.
        while (true) {
            switch (selection) {
                case "D": addTransaction(true);   // if d is selected then it will run add deposit method
                    break;
                case "P": addTransaction(false);  // if p is selected then it will run make payment method
                    break;
                case "L": showLedgerMenu();// if L is selected then it will run Ledger method and open the ledger screen
                    break;
                case "X": System.exit(0);// if x is selected then it will exit the program
                default:
                    System.out.println("Invalid input. Try again");
            }
        }

    }
    //Ledger menu options
    // 1. all entries
    // 2. all deposit entries
    // 3. display all the negative (payment) entries
    // 4. reports( opens another menu)

    private static void showLedgerMenu() {
        System.out.println("--💰---Ledger menu---💰--");
        System.out.println("    A) All entries     ");
        System.out.println("    D) All deposit entries");
        System.out.println("    P) Display all payment entries");
        System.out.println("    R) Reports");
        System.out.println("    X) Previous Menu");

        String entry = Myscanner.nextLine().toUpperCase();
            switch (entry) {
                case "A":  AllEntriesDisplay();      // if A is selected then it will display all the entries
                    break;
                case "D":  DisplayDeposits(); // if d is selected then it will display all the deposits
                    break;
                case "P":  DisplayPayments();// if p is selected then it will display all the payments
                    break;
                case "R":   ReportService();
                case "X":   System.exit(1);// return to previous menu
                default:
                    System.out.println("Invalid input. Try again");
            }
        }

    private static void DisplayPayments() {
        //DisplayPayments;
    }

    private static void DisplayDeposits() {
        List<Transaction> transactions = TransactionService.loadTransactions();//deposits();
    }

    private static void AllEntriesDisplay() {
        List<Transaction> transactions = TransactionService.loadTransactions();//allEntries();
    }

    private static void ReportService() {
          // if x is selected then it will open a report menu to do custom filtering
        //1) Month To Date
        //§ 2) Previous Month
        //§ 3) Year To Date
        //§ 4) Previous Year
        //§ 5) Search by Vendor - prompt the user for the vendor name
        //and display all entries for that vendor
        //§ 0) Back - go back to the Ledger page
        String Rselect = Myscanner.nextLine();
        while (true) {
            switch (Rselect) {
                case "M": ;   // month to date method
                    break;
                case "P":     // previous month
                    break;
                case "Y":     // year to date method
                    break;
                case "V":     // search by vendor
                case "X": System.exit(2); // if x is selected then it will exit the program
                default:
                    System.out.println("Invalid input. Try again");
            }
        }
    }

    // Call the methods:
    // addTransaction(true) for deposits [D]
    // ddTransaction(false) for payments [P]
    public static void addTransaction(boolean isDeposit) {                  // In method addTransaction(boolean isDeposit) Prompt for
        System.out.println(" what is this deposit for? ");
        String description = Myscanner.nextLine();                  // - Description
        System.out.println(" WHo is the Vendor? ");
        String vendor = Myscanner.nextLine();                       //- Vendor
        System.out.println("What is the amount? ");
        double amount = parseDouble(Myscanner.nextLine());          //- Amount

        if (isDeposit) {                                           // Makes amount negative if it's a payment (isDeposit == false)
            amount *= -1;
        }

        // Create a Transaction object with LocalDate.now() and LocalTime.now()

        // Call TransactionService.saveTransaction(transaction)

        //Print a confirmation message (add flair if you want!)

    }

}











