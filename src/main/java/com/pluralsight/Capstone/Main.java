package com.pluralsight.Capstone;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import com.pluralsight.Capstone.LedgerReports;

public class Main {
    static Scanner Myscanner = new Scanner(System.in); //Scanner to let us read user input

    public static void main(String[] args) {
        //Create a loop that keeps the app running until the user chooses “X”

        //Handle user input with a switch block. Using while to make a loop.
        while (true) {
            //Display menu options:

            System.out.println("--💸---Home Screen---💸--");
            System.out.println("    D) Add Deposit        ");
            System.out.println("    P) Make Payment       ");
            System.out.println("    L) Ledger             ");
            System.out.println("    X) Exit               ");

            String selection = Myscanner.nextLine().toUpperCase();
            switch (selection) {
                case "D": addTransaction(true);   // if D is selected then it will run add deposit method
                    break;
                case "P": addTransaction(false);  // if p is selected then it will run make payment method
                    break;
                case "L": showLedgerMenu();                // if L is selected then it will run Ledger method and open the ledger screen
                    break;
                case "X": System.exit(0);           // if X is selected then it will exit the program
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

        while (true){
        System.out.println("---💰---Ledger menu---💰---");
        System.out.println("    A) All entries         ");
        System.out.println("    D) All deposit entries ");
        System.out.println("    P) All payment entries ");
        System.out.println("    R) Reports             ");
        System.out.println("    X) Previous Menu       ");

        String entry = Myscanner.nextLine().toUpperCase();
        switch (entry) {
                case "A":  AllEntriesDisplay();  // if A is selected then it will display all the entries
                    break;
                case "D":  DisplayDeposits();    // if D is selected then it will display all the deposits
                    break;
                case "P":  DisplayPayments();    // if P is selected then it will display all the payments
                    break;
                case "R":  ReportService();      // if R is selected thn it will open the report menu
                case "X":  return;              // return to previous menu
            default:
                    System.out.println("Invalid input. Try again");
            }
        }}

    private static void DisplayPayments() {
       List<Transaction> transactions = TransactionService.loadTransactions();//payments();
        for (Transaction t : transactions) {
            System.out.println(t.toCSV());
        }
    }

    private static void DisplayDeposits() {
        List<Transaction> transactions = TransactionService.loadTransactions();//deposits();
        for (Transaction t : transactions) {
            System.out.println(t.toCSV());
        }
    }

    private static void AllEntriesDisplay() {
        List<Transaction> transactions = TransactionService.loadTransactions();//allEntries();
        for (Transaction t : transactions) {
            System.out.println(t.toCSV());
        }
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

        while (true) {
            System.out.println("--📊 Reports Menu 📊 --");
            System.out.println("  M) Month To Date     ");
            System.out.println("  P) Previous Month    ");
            System.out.println("  Y) Year To Date      ");
            System.out.println("  V) Search by Vendor  ");
            System.out.println("  X) Back              ");

            String Rselect = Myscanner.nextLine();
            List<Transaction> transactions = TransactionService.loadTransactions();
            LedgerReports.reportMonthToDate(transactions);
            switch (Rselect) {
                case "M":    LedgerReports.reportMonthToDate(transactions);    // month to date method
                    break;
                case "P":    LedgerReports.reportPreviousMonth(transactions);  // previous month
                    break;
                case "Y":    LedgerReports.reportYearToDate(transactions);     // year to date method
                    break;
                case "V":    LedgerReports.reportByVendor(transactions, Rselect);  // search by vendor
                case "X":    showLedgerMenu();                                  // if x is selected then it will go back to  ledger menu
                    break;
                default:
                    System.out.println("Invalid input. Try again");
            }
        }
    }

    // Call the methods:
    // addTransaction(true) for deposits [D]
    // addTransaction(false) for payments [P]
    public static void addTransaction(boolean isDeposit) {          // In method addTransaction(boolean isDeposit) Prompt for
        System.out.println(" what is this transaction for? ");
        String description = Myscanner.nextLine();                  // - Description
        System.out.println(" Who is the Vendor? ");
        String vendor = Myscanner.nextLine();                       //- Vendor
        System.out.println(" What is the amount? ");
        double amount = Double.parseDouble((Myscanner.nextLine())); //- Amount

        if (!isDeposit) {                                           // Makes amount negative if it's a payment (isDeposit == false)
            amount *= -1;
        }
        Transaction transaction = new Transaction(                 // Adds local date and time to every transaction
                LocalDate.now(),
                LocalTime.now(),
                description,
                vendor,
                amount
        );

        TransactionService.saveTransaction(transaction);
        System.out.println("✅ Transaction saved: " + transaction.toCSV());
    }

}