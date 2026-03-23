package ExpnTckr;

public class ExpenseModel {
    private int id;
    String description;
    private double amount;
    String date;

    ExpenseModel(int id, String description, double amount, String date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }
    public int getId() {
        return id;
    }
    public double getAmount() {
        return amount;
    }
}
