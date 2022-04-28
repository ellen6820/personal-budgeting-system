package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

import javax.naming.InsufficientResourcesException;

public class User {
    public double balance;
    public double weeklyLimit;
    public ArrayList<Goal> userGoals;
    public ArrayList<Transaction> transactions;
    public double income;
    public String email;

    public User(double balance, double weeklyLimit, String email) {
        this.balance = balance;
        this.email = email;
        this.weeklyLimit = weeklyLimit;
        this.transactions = new ArrayList<Transaction>();
        this.userGoals = new ArrayList<Goal>();

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

    public double getIncome() {
        return income;
    }

    public ArrayList<Transaction> getTransactionHistory(){
        return transactions;
    }

    public double createLimit(double weeklyLimit) throws InvalidInputException {
        if (weeklyLimit < 0) {
            throw new InvalidInputException("Enter a valid amount");
        } else {
            return weeklyLimit;
        }
    }

    Goal createGoal(String goals, double amount) throws InvalidInputException {
        Goal newGoal = new Goal(goals, amount);
        if(amount < 0){
            userGoals.add(newGoal);
        }
        else{
            throw new InvalidInputException("Enter a valid amount");
        }
        

        return newGoal;
    }

    public double addIncome(double income) throws InvalidInputException {
        if (income <= 0) {
            throw new InvalidInputException("Enter a valid Income");
        } else {
            return income;
        }
    }

    public String seeHistory() {
        String output = "";
        double sumAmount = 0;
        for (int i = 0; i < transactions.size(); i++) {
            output += "#" + (i + 1) + ": {" + transactions.get(i).type + ", $" + transactions.get(i).amount + "}\n";
            sumAmount += transactions.get(i).amount;
        }
        output += "Total: " + sumAmount;
        return output;
    }

    Transaction createTransaction(String type, double amount) throws InsufficientResourcesException {

        if (balance > amount){
            Transaction newTransaction = new Transaction(type, amount);
            balance = balance - amount;
            transactions.add(newTransaction);
            return newTransaction;
        }
        else {
            throw new InsufficientResourcesException("You do not have enough money to make this purchase");
        }
    }
}