package com.pluralsight.Capstone;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {

    //Purpose of this class: Represents a transaction

    // Characteristics of every transaction
    // Contains: Fields: date, time, description, vendor, amount
    // as stated in the capstone workbook
    private LocalDate date;

    private LocalTime time;

    private String description;

    private String vendor;

    private double amount;


    // Constructor to allow us to create an object
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //Getters and setters
    // these are methods that let us access and modify fields of a class

    // getters

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

    //setters

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    // Other Methods:

    //method to use to save the transaction, formatted, to the csv file
    public String toCSV() {
    return String.format("%    s  | %    s  | %    s  |   %   s  | %2f ", date, time, description, vendor, amount);


    }
    //isDeposit(), and isPayment() methods for filtering
    //it's a payment if the amount is less than 0
    public boolean isPayment() {
        return amount < 0;
    }

    //it's a deposit if the amount is greater than 0
    public boolean isDeposit() {
        return amount > 0;
    }

    //toString() – for display
    //has to be overridden so that we get an output that we can read and understand
    // the hashcode is no good for us in this application

    @Override
    public String toString() {
        return "Transaction{" + "date = " + date + ", time = " + time + ", description = '" + description + '\'' + ", vendor = '" + vendor + '\'' + ", amount = " + amount + '}';
    }
    }

