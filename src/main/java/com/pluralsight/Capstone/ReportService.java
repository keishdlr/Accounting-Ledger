package com.pluralsight.Capstone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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
        for (Transaction t : transactions) {
            if (t.isDeposit()) {
                System.out.println(t.toCSV());

            }
        }
    }

    // Display only payments (amount < 0)
    public static void displayPayments(List<Transaction> transactions) {
        for (Transaction t : transactions) {
            if (t.isPayment()) {
                System.out.println(t.toCSV());
            }
        }
    }

    // Display transactions from the current month
    public static void reportMonthToDate(List<Transaction> transactions) {
        //Get today's date
        LocalDate now = LocalDate.now();
        // for loop to go through each transaction in the list
        for (Transaction t : transactions) {
            //nested if statement to check if the month and year is the same as today
            if (t.getDate().getMonth() == now.getMonth() &&
                    t.getDate().getYear() == now.getYear()) {
                // print the transaction that matches the year and month
                System.out.println(t.toCSV());
            }
        }
    }
    // Export selected filtered list of transactions to a new CSV file
     try (BufferedWriter writer = new BufferedWriter(new FileWriter("CustomReport.csv", true)) {
        //writes the filtered transaction in the csv format (CustomReport.java) and eats the buffer
        writer.write(t.toCSV()); // Assumes Transaction has a toCsv() method
        writer.newLine();
    } catch(IOException e)
    {
        //error message when writing fails
        System.err.println("Error saving transaction: " + e.getMessage());
    }}



