package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

public class User{
    
    public double balance;
    public double weeklyLimit;
    public ArrayList<String> userGoals;
    public double income;
    public String email;
    public ArrayList<Child> children;

    public User(double balance, double weeklyLimit, String email){
        this.balance = balance;
        this.email = email;
        this.weeklyLimit = weeklyLimit;

        children = new ArrayList<Child>();
    }

    
    public String getEmail(){
        return email;
    }
    
    public double getBalance(){
        return balance;
    }

    public double getLimit(){
        return weeklyLimit;
    }

    public double getIncome(){
        return income;
    }
    
    public ArrayList<Child> getChildren(){
        return children;
    }

    public double createLimit(double weeklyLimit) throws InvalidInputException{
        if(weeklyLimit < 0){
            throw new InvalidInputException("Enter a valid amount");
        }
        else{
            return weeklyLimit;
        }
    }

    public void createGoal(){

    }

    public double addIncome(double income) throws InvalidInputException{
        if(income <= 0){
            throw new InvalidInputException("Enter a valid Income");
        }else{
            return income;
        }
        
    }

    public void seeHistory(){

    }

    public void createTransaction(){
        
    }


}