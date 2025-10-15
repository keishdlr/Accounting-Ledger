package com.pluralsight.Capstone;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {
// Defined the fields that make up a transaction
// Lets me create, save, and load transactions
// Acts as a bridge between the user interface and your file/database

    //Purpose of the TransactionService class: Handles file reading and adding transactions
    //Contains: methods for reading and adding transactions to the file

    //reads from transactions.csv;
    //- Reads from transactions.csv using buffered I/O
    //- Parses each line into a Transaction object
    //- Handles malformed lines with a length check
    public static List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>(); // return transactions as a list
        //try with resources makes sure the file closes automatically
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
            //Read each line
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|"); // Split line into (5) parts

                //Ensure the line has all the expected fields
                if (parts.length == 5) {         // checks for proper input by checking the length
                    LocalDate date = LocalDate.parse(parts[0]); // part 1 (index 0) is the date
                    LocalTime time = LocalTime.parse(parts[1]); // part 2 (index 1) is time
                    String description = parts[2];              // part 3 (index 2) is the description
                    String vendor = parts[3];                   // part 4 (index 3) is the vendor
                    double amount = Double.parseDouble(parts[4]); // part 5 (index 4) is the amount

                    //creates object and adds it to the list
                    transactions.add(new Transaction(date, time, description, vendor, amount));
                } else {
                    System.err.println("Skipping malformed line: " + line); // when if fails it goes to this line and skips the input
                }
            }
        } catch (IOException e) {
            //Prints error message when file reading fails
            System.err.println("Error reading transaction: " + e.getMessage());

        }
        return transactions;
    }

    //appends a new transaction to the csv file
    public static void saveTransaction(Transaction t){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.csv", true))) {
        //writes the transaction in the csv format (transaction.java) and eats the buffer
        writer.write(t.toCSV()); // Transaction has a toCsv() method
        writer.newLine();        // eats the line
    } catch (IOException e) {
        //error message when writing fails
        System.err.println("Error saving transaction: " + e.getMessage());
    }}
}

