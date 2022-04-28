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
        return null;
    }

    Transaction createTransaction(String type, double amount) throws InsufficientResourcesException {
        Transaction newTransaction = new Transaction(type, amount);

        transactions.add(newTransaction);

        if (balance > amount){
            balance = balance - amount;
        }
        else {
            throw new InsufficientResourcesException("You do not have enough money to make this purchase");
        }

        return newTransaction;
    }
}