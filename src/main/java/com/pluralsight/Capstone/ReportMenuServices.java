package com.pluralsight.Capstone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReportMenuServices {
    //Report Methods

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
                MonthToDate.add(t);
            }}
        // Sort by date and time, newest first
        MonthToDate.sort(
                Comparator.comparing(Transaction::getDate)
                        .thenComparing(Transaction::getTime)
                        .reversed()
        );

        for (Transaction t : MonthToDate) {
            System.out.println(t.toCSV());
        }


        // Export selected filtered list of transactions to a new CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("MonthToDateReport.csv", true))) {
            for (Transaction t : MonthToDate) {
                writer.write(t.toCSV());
                writer.newLine();        // Move to the next line
            }
        } catch (IOException e) {
            //Print error message if writing fails
            System.err.println("Error saving transaction: " + e.getMessage());
        }
    }

    // Display transactions from the previous month
    public static void reportPreviousMonth(List<Transaction> transactions) {
        List<Transaction> PreviousMonth = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate previousMonth = now.minusMonths(1);
        for (Transaction t : transactions) {
            if (t.getDate().getMonth() == previousMonth.getMonth() &&
                    t.getDate().getYear() == previousMonth.getYear()) {
                PreviousMonth.add(t);
            }
        }
        PreviousMonth.sort(Comparator.comparing(Transaction::getDate).reversed());
        for (Transaction t : PreviousMonth) {
            System.out.println(t.toCSV());
        }

    }
    // Display transactions from the current year
    public static void reportYearToDate(List<Transaction> transactions) {
        List<Transaction> Year = new ArrayList<>();
        int currentYear = LocalDate.now().getYear();
        for (Transaction t : transactions) {
            if (t.getDate().getYear() == currentYear) {
                Year.add(t);
            }
        }
        Year.sort(Comparator.comparing(Transaction::getDate).reversed());
        for (Transaction t : Year) {
            System.out.println(t.toCSV());

        }
    }

    // Display transactions by vendor name
    public static void reportByVendor(List<Transaction> transactions, String vendorName) {
        List<Transaction> Vendor = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getVendor() != null && t.getVendor().equalsIgnoreCase(vendorName.trim())) {
                Vendor.add(t);
            }
        }
        Vendor.sort(Comparator.comparing(Transaction::getDate).reversed());
        for (Transaction t : Vendor) {
            System.out.println(t.toCSV());

        }}}
