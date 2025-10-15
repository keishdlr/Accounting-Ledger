package com.pluralsight.Capstone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LedgerMenuServices {

    //Purpose: Handles filtering and reporting logic
    //Contains:
    //- displayAllTransactions(List<Transaction>)
    //- displayDeposits(List<Transaction>)
    //- displayPayments(List<Transaction>)
    //- reportMonthToDate(List<Transaction>)
    // Display all transactions
    public static void displayAllTransactions(List<Transaction> transactions) {
        transactions.sort(Comparator.comparing(Transaction::getDate).reversed()); // sort by newest first
        for (Transaction t : transactions) {
            System.out.println(t.toCSV());
        }
    }

    // Display only deposits (amount > 0)
    public static void displayDeposits(List<Transaction> transactions) {
        List<Transaction> DepositsOnly = new ArrayList<>(); //array that collects all the deposits
        for (Transaction t : transactions) {
            if (t.isDeposit()) {
                System.out.println(t.toCSV()); // Displays only deposits
                DepositsOnly.add(t);    // adds new transactions to the custom report file called DepositReport
            }
        }
        // Export selected filtered list of transactions to a new CSV file
        DepositsOnly.sort(Comparator.comparing(Transaction::getDate).reversed()); //sort by newest first
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("DepositReport.csv", true))) {
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
                System.out.println(t.toCSV()); //Displays only payments
                PaymentsOnly.add(t); // adds to the PaymentReport
            }
        }
        PaymentsOnly.sort(Comparator.comparing(Transaction::getDate).reversed()); // sorting
        // Export selected filtered list of transactions to a new CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PaymentsReport.csv", true))) {
            for (Transaction t :PaymentsOnly) {
                writer.write(t.toCSV()); // Assumes Transaction has a toCsv() method
                writer.newLine();        // Move to the next line
            }
        } catch (IOException e) {
            //Print error message if writing fails
            System.err.println("Error saving transaction: " + e.getMessage());
        }
    }}

