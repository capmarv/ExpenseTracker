package ExpnTckr;

import java.io.*;

public class ExpenseService {

    public static void addExpense(String[] args) throws IOException {

        String description = null;
        double amount = 0;

        for(int i = 0; i < args.length; i++) {
            if(args[i].equals("--description")) {
                description = args[i+1];
            }  else if(args[i].equals("--amount")) {
                amount = Double.parseDouble(args[i+1]);
            }
        }
        if(description == null || amount <= 0) {
            System.out.println("Please enter description and amount with valid inputs.");
        } else {
            int id = getExpenseId();
            String date = java.time.LocalDate.now().toString();
            System.out.println("Adding expense: " + description + " with " + amount + " in " + "rupees");
            BufferedWriter writer = new BufferedWriter(new FileWriter("csv.txt", true));
            writer.write(id + "," + description + "," + amount + "," + date + "\n");
            writer.close();
        }
    }

    public static void deleteExpense(String[] args) throws IOException {


    }

    public static void updateExpense() {

    }

    public static void showExpense() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("csv.txt"));
        String line;
        System.out.printf("%-5s %-15s %-20s %-10s%n", "ID", "DATE", "DESCRIPTION", "AMOUNT");

        while((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] fields = line.split(",");
            if (fields.length < 4) {
                System.out.println("Skipping invalid line: " + line);
                continue;
            }
            int id = Integer.parseInt(fields[0]);
            String date = fields[3];
            String description = fields[1];
            double amount = Double.parseDouble(fields[2]);

            System.out.printf("%-5d %-15s %-20s %-10.2f%n", id, date, description, amount);
        }
        reader.close();
    }

    public static void showSummary() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("csv.txt"));
        String line;
        double sum = 0;
        while((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] fields = line.split(",");
            if (fields.length < 4) {
                System.out.println("Skipping invalid line: " + line);
                continue;
            } else {
                double amount = Double.parseDouble(fields[2]);
                sum += amount;
            }
        }
        reader.close();
        System.out.printf("Total expenses: %.2f in rupees%n", sum);
    }

    public static int getExpenseId() throws IOException {
        int max = 0;
        BufferedReader reader = new BufferedReader(new FileReader("csv.txt"));
        String line;
        while((line = reader.readLine()) != null) {
            if(line.trim().isEmpty()) continue;
            String[] fields = line.split(",");
            int id = Integer.parseInt(fields[0]);
            if(id > max) max = id;
        }
        reader.close();
        return max + 1;
    }
}
