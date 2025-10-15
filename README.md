# 💰 CLI Finance Tracker

This command-line application helps users manage personal transactions by saving, viewing, and organizing financial data in a CSV file.

---

## Project Structure

Each class in this project has a clear and focused responsibility:

### `Main.java`
Handles **user interaction** and **menu logic**.
- Customized greeting with name and time of day
- Displays Menu options
- Prompts user input to the appropriate service or feature

### `Transaction.java`
Defines the **data model** for a transaction.
- Specifies fields: `date`, `time`, `description`, `vendor`, `amount`
- Groups related data into a single object
- CSV formatting via `toCSV()` method

### `TransactionService.java`
Manages **file handling** for transactions.
- Loads transactions from `transactions.csv`
- Appends new transactions

### `ReportService.java` and `LedgerReports.java`
Provides **filtering and reporting logic**.
- Generates summaries or filtered views (e.g., by vendor or date)
- Generates new file for filtered views

### `Images`
![<img width="287" height="172" alt="Home Screen and greeting" src="https://github.com/user-attachments/assets/1afb46aa-9ab2-43b7-ad13-59d72617defc" />](Images/Home Screen and greeting.png)


![<img width="297" height="173" alt="Ledger Menu" src="https://github.com/user-attachments/assets/def81aeb-dae6-4ece-9c7e-e9913212a707" />](Images/Ledger Menu.png)


![<img width="267" height="171" alt="Reports Menu" src="https://github.com/user-attachments/assets/224eca7c-b003-430d-b652-3dcbb05b4475" />](Images/Reports Menu.png)


![<img width="297" height="132" alt="CSV files" src="https://github.com/user-attachments/assets/ee1a5421-bc4d-40bc-9eb3-2f3af6ecc9a5" />](Images/CSV files.png)

---
