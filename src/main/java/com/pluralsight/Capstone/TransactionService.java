package com.pluralsight.Capstone;

public class TransactionService {
    //✅ TransactionService Class
    //Purpose: Handles file I/O (reading/writing transactions)
    //Contains:
    //- loadTransactions() – reads from transactions.csv
    //- saveTransaction(Transaction t) – appends a new transaction
    //- overwriteTransactions(List<Transaction>) – rewrites the file (for editing/deleting)
    //
    //✅ (Optional) Ledger or ReportService Class
    //Purpose: Handles filtering and reporting logic
    //Contains:
    //- displayAllTransactions(List<Transaction>)
    //- displayDeposits(List<Transaction>)
    //- displayPayments(List<Transaction>)
    //- reportMonthToDate(List<Transaction>), etc.
    //You can keep these in Main for now, but if they grow large, moving them into a separate class like ReportService or LedgerUtils will keep things clean.
    //
    //🧠 TL;DR
    //- Main.java → User interaction + menu logic
    //- Transaction.java → Data model
    //- TransactionService.java → File handling
    //- (Optional) Report/Ledger class → Filtering/reporting logic
    //
    //Want help scaffolding one of those classes next? Maybe we can wire up the addTransaction() method together!
}
