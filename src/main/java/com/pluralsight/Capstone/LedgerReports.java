package com.pluralsight.Capstone;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static com.pluralsight.Capstone.Main.Myscanner;

public class LedgerReports {
    //Report Methods

// Display transactions from the current month
    public static void reportMonthToDate(List<Transaction> transactions) {
        LocalDate now = LocalDate.now();
        for (Transaction t : transactions) {
            if (t.getDate().getMonth() == now.getMonth() && t.getDate().getYear() == now.getYear()) {
                System.out.println(t.toCSV());
            }
        }
    }

    // Display transactions from the previous month
    public static void reportPreviousMonth(List<Transaction> transactions) {
        LocalDate now = LocalDate.now();
        LocalDate previousMonth = now.minusMonths(1);
        for (Transaction t : transactions) {
            if (t.getDate().getMonth() == previousMonth.getMonth() &&
                    t.getDate().getYear() == previousMonth.getYear()) {
                System.out.println(t.toCSV());
            }
        }
    }
    // Display transactions from the current year
    public static void reportYearToDate(List<Transaction> transactions) {
        int currentYear = LocalDate.now().getYear();
        for (Transaction t : transactions) {
            if (t.getDate().getYear() == currentYear) {
                System.out.println(t.toCSV());
            }
        }
    }

    // Display transactions by vendor name
    public static void reportByVendor(List<Transaction> transactions, String vendorName) {
        vendorName = Myscanner.nextLine();
        for (Transaction t : transactions) {
            if (t.getVendor().equalsIgnoreCase(vendorName.trim())) {
                System.out.println(t.toCSV());
            }
        }
    }
    }
