# Expense Tracker CLI (Java)

A simple command-line application built using Java to manage daily expenses.  
The application stores data in a CSV file and displays expenses in a formatted table.

---

## Features
- Add new expenses
- Update existing expenses
- Delete expenses
- View all expenses in a table format
- View total expense summary

---

## Tech Stack
- Java
- File Handling (CSV)
- Command Line Interface (CLI)

---

## How to Run
javac src/ExpnTckr/*.java  
java -cp src ExpnTckr.Main <command>

---

## Commands

Add Expense:  
java -cp src ExpnTckr.Main add --description "Lunch" --amount 200

View All Expenses:  
java -cp src ExpnTckr.Main show

View Summary:  
java -cp src ExpnTckr.Main summary

Update Expense:  
java -cp src ExpnTckr.Main update --id 1 --description "Dinner" --amount 300

Delete Expense:  
java -cp src ExpnTckr.Main delete --id 1

---

## Data Storage
All expenses are stored in a `csv.txt` file in the format:  
id,description,amount,date

Example:  
1,Lunch,200,2026-04-10

---

## Limitations
- Uses file storage (no database)
- No category or filtering support
- No monthly summary yet
- No external libraries are used

---

## Author
capmarv
