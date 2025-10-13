package com.pluralsight.Capstone;

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
        }}
        // Display transactions from the current month
        public static void reportMonthToDate (List < Transaction > transactions) {
            LocalDate now = LocalDate.now();
            for (Transaction t : transactions) {
                if (t.getDate().getMonth() == now.getMonth() &&
                        t.getDate().getYear() == now.getYear()) {
                    System.out.println(t.toCSV());
                }
            }
        }
    }


