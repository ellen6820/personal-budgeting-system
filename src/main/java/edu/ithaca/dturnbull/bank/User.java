package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;
import javax.naming.InsufficientResourcesException;

public class User {
    private double balance;
    private double weeklyLimit;
    private ArrayList<Goal> userGoals;
    private ArrayList<Transaction> transactions;
    private String email;

    public User(double balance, double weeklyLimit, String email) {
        this.balance = balance;
        this.weeklyLimit = weeklyLimit;
        this.userGoals = new ArrayList<Goal>();
        this.transactions = new ArrayList<Transaction>();
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public double getLimit() {
        return weeklyLimit;
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    /**
     * 
     * @param weeklyLimit
     * @return a user's weekly limit
     * @throws InvalidInputException
     */
    public double createLimit(double weeklyLimit) throws InvalidInputException {
        if (weeklyLimit < 0) {
            throw new InvalidInputException("Enter a valid amount");
        } else {
            this.weeklyLimit = weeklyLimit;
            return weeklyLimit;
        }
    }

    /**
     * 
     * @param goals
     * @param amount
     * @return a goal that the user is saving up for
     * @throws InvalidInputException
     */
    Goal createGoal(String goals, double amount) throws InvalidInputException {
        Goal newGoal = new Goal(goals, amount);
        if (amount < 0){
            userGoals.add(newGoal);
        } else {
            throw new InvalidInputException("Enter a valid amount");
        }
        return newGoal;
    }

    /**
     * 
     * @param income
     * @return a user's balance with new income amount added
     * @throws InvalidInputException
     */
    public double addIncome(double income) throws InvalidInputException {
        if (income <= 0) {
            throw new InvalidInputException("Enter a valid Income");
        } else {
            balance += income;
            return balance;
        }
    }

    /**
     * 
     * @return a string with a user's most recent transactions
     */
    public String seeHistory() {
        String output = "";
        double sumAmount = 0;

        //last 10 transactions only 
        int startParse = 0;
        if (transactions.size() > 10) {
            output += "...\n";
            startParse = transactions.size() - 10;
        }

        for (int i = startParse; i < transactions.size(); i++) {
            output += "#" + (i + 1) + ": {" + transactions.get(i).getType() + ", $" + transactions.get(i).getAmount() + "}\n";
            sumAmount += transactions.get(i).getAmount();
        }
        output += "Total Spent: $" + sumAmount;
        return output;
    }

    Transaction createTransaction(String type, double amount) throws InsufficientResourcesException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Negative purchase");
        } else if (balance > amount){
            Transaction newTransaction = new Transaction(type, amount);
            balance = balance - amount;
            transactions.add(newTransaction);
            return newTransaction;
        } else {
            throw new InsufficientResourcesException("You do not have enough money to make this purchase");
        }
    }
}  
