package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

public class User{
    
    public double balance;
    public double weeklyLimit;
    public ArrayList<String> userGoals;
    public double income;
    public String email;

    public User(double balance, String email){
        this.balance = balance;
        this.email = email;
        
    }

    public double getIncome(){
        return income;
    }

    public double getLimit(){
        return weeklyLimit;
    }
    
    public String getEmail(){
        return email;
    }
    
    public double getBalance(){
        return balance;
    }

    public void createLimit(){

    }

    public void createGoal(){

    }

    public void addIncome(){

    }

    public void seeHistory(){

    }

    public void createTransaction(){
        
    }


}