package com.pluralsight.Capstone;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {
// Defined the fields that make up a transaction
// Lets me create, save, and load transactions
// Acts as a bridge between your user interface and your file/database

    //Purpose of this class: Handles file reading and adding transactions
    //Contains: methods for reading and adding transactions to the file

    //reads from transactions.csv;
    //- Reads from transactions.csv using buffered I/O
    //- Parses each line into a Transaction object
    //- Handles malformed lines with a length check
    public static List<Transaction> loadTransactions()
        List<Transaction> transactions = new ArrayList<>(); // return transactions as a list
        //try with resources makes sure the file closes automatically
        try(BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
            //Read each line
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split("\\|"); // Split line into parts

                //Ensure the line has all the expected fields
                if (parts.length == 5) {
                    LocalDate date = LocalDate.parse(parts[0]);
                    LocalTime time = LocalTime.parse(parts[1]);
                    String description = parts[2];
                    String vendor = parts[3];
                    double amount = Double.parseDouble(parts[4]);

                    //creates object and adds it to list
                    transactions.add(new Transaction(date, time, description, vendor, amount));
                }
                else {
                    System.err.println("Skipping malformed line: " + line);
                }
            }
        } catch (IOException e) {
            //Prints error message when file reading fails
            System.err.println("Error reading transaction: " + e.getMessage());
            return transactions;
        }

    //appends a new transaction the csv file
    public static void saveTransaction(Transaction t){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true))) {
        //writes the transaction in the csv format (transaction.java) and eats the buffer
        writer.write(t.toCSV()); // Assumes Transaction has a toCsv() method
        writer.newLine();
    } catch (IOException e) {
        //error message when writing fails
        System.err.println("Error saving transaction: " + e.getMessage());
    }}

    // rewrites the file (for editing/deleting)
    public static void overwriteTransactions(List<Transaction>transactions){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv"))) {
            for (Transaction t : transactions) {
                writer.write(t.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error overwriting transactions: " + e.getMessage());
        }
    }
}
        }}}
