package ExpnTckr;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileService.initializeFile();

        if(args.length == 0) {
            System.out.println("please provide an action!");
            return;
        }
        String action = args[0];
        switch(action) {
            case "add" -> ExpenseService.addExpense(args);
            case "delete" -> ExpenseService.deleteExpense(args);
            case "update" -> ExpenseService.updateExpense(args);
            case "show" -> ExpenseService.showExpense();
            case "summary" -> ExpenseService.showSummary();
            default -> System.out.println("invalid action.");
        }
    }
}