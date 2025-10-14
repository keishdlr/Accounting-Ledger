package com.pluralsight.Capstone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReportMenuServices {
    //Report Methods

    // Display transactions from the current month
    public static void reportMonthToDate(List<Transaction> transactions) {
        List<Transaction> MonthToDate = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (Transaction t : transactions) {
            if (t.getDate().getMonth() == now.getMonth() && t.getDate().getYear() == now.getYear()) {
                System.out.println(t.toCSV());
                MonthToDate.add(t);
            }
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
                System.out.println(t.toCSV());
                PreviousMonth.add(t);
            }
        }
    }
    // Display transactions from the current year
    public static void reportYearToDate(List<Transaction> transactions) {
        List<Transaction> Year = new ArrayList<>();
        int currentYear = LocalDate.now().getYear();
        for (Transaction t : transactions) {
            if (t.getDate().getYear() == currentYear) {
                System.out.println(t.toCSV());
                Year.add(t);
            }
        }
    }

    // Display transactions by vendor name
    public static void reportByVendor(List<Transaction> transactions, String vendorName) {
        List<Transaction> Vendor = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getVendor().equalsIgnoreCase(vendorName.trim())) {
                System.out.println(t.toCSV());
                Vendor.add(t);
            }
        }
    }
    }
