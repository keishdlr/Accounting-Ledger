package com.pluralsight.Capstone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReportService {

    //Purpose: Handles filtering and reporting logic
    //Contains:
    //- displayAllTransactions(List<Transaction>)
    //- displayDeposits(List<Transaction>)
    //- displayPayments(List<Transaction>)
    //- reportMonthToDate(List<Transaction>)
    // Display all transactions
    public static void displayAllTransactions(List<Transaction> transactions) {
        for (Transaction t : transactions) {
            System.out.println(t.toCSV());
        }
    }

    // Display only deposits (amount > 0)
    public static void displayDeposits(List<Transaction> transactions) {
        List<Transaction> DepositsOnly = new ArrayList<>(); //array that collects all the deposits
        for (Transaction t : transactions) {
            if (t.isDeposit()) {
                System.out.println(t.toCSV());
                DepositsOnly.add(t);    // adds new transactions to the custom report file called DepositReport
            }
        }
        // Export selected filtered list of transactions to a new CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DepositReport.csv", false))) {
            for (Transaction t : DepositsOnly) {
                writer.write(t.toCSV()); // Assumes Transaction has a toCsv() method
                writer.newLine();        // Move to the next line
            }
        } catch (IOException e) {
            //Print error message if writing fails
            System.err.println("Error saving transaction: " + e.getMessage());
        }
    }

    // Display only payments (amount < 0)
    public static void displayPayments(List<Transaction> transactions) {
        List <Transaction> PaymentsOnly = new ArrayList<>(); // array that collects all the payments
        for (Transaction t : transactions) {
            if (t.isPayment()) {
                System.out.println(t.toCSV());
                PaymentsOnly.add(t); // adds to the PaymentReport
            }
        }
        // Export selected filtered list of transactions to a new CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PaymentsReport.csv", false))) {
            for (Transaction t :PaymentsOnly) {
                writer.write(t.toCSV()); // Assumes Transaction has a toCsv() method
                writer.newLine();        // Move to the next line
            }
        } catch (IOException e) {
            //Print error message if writing fails
            System.err.println("Error saving transaction: " + e.getMessage());
        }
    }

    // Display transactions from the current month
    public static void reportMonthToDate(List<Transaction> transactions) {
        List<Transaction> MonthToDate = new ArrayList<>();
        //Get today's date
        LocalDate now = LocalDate.now();
        // for loop to go through each transaction in the list
        for (Transaction t : transactions) {
            //nested if statement to check if the month and year is the same as today
            if (t.getDate().getMonth() == now.getMonth() &&
                    t.getDate().getYear() == now.getYear()) {
                // print the transaction that matches the year and month
                System.out.println(t.toCSV());
                MonthToDate.add(t);      // used diff letter 'm' because using 't' was giving an error
            }}
            // Export selected filtered list of transactions to a new CSV file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("MonthToDateReport.csv", false))) {
                for (Transaction t : MonthToDate) {
                    writer.write(t.toCSV()); // Assumes Transaction has a toCsv() method
                    writer.newLine();        // Move to the next line
                }
            } catch (IOException e) {
                //Print error message if writing fails
                System.err.println("Error saving transaction: " + e.getMessage());
            }
    }
}

