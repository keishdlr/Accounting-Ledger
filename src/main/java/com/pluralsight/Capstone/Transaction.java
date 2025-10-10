package com.pluralsight.Capstone;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    //Purpose of this class: Represents a single transaction

    // Characteristics of every transaction
    // Contains: Fields: date, time, description, vendor, amount
    private LocalDate date;

    private LocalTime time;

    private String description;

    private String vendor;

    private double amount;


    //- Constructor

    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }


    // Methods:

    //- toCsv() – for saving to file
    public static void toCSV() {

    }

    public static void isPayment() {

}

    //- toString() – for display

    @Override
    public String toString() {
        return "Transaction{" + "date = " + date + ", time = " + time + ", description = '" + description + '\'' + ", vendor = '" + vendor + '\'' + ", amount = " + amount + '}';
    }

    //- isDeposit(), and isPayment() – for filtering

    public static void isDeposit() {

    }


    }

