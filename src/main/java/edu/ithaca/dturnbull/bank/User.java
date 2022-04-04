package edu.ithaca.dturnbull.bank;

import java.lang.reflect.Array;

public class User{
    
    public double balance;
    public double weeklyLimit;
    public Array userGoals[];
    public double income;
    public String email;

    public User(double balance, double weeklyLimit, Array userGoals, double income, String email){
        
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

    public void createGoal(){ //needs a date

    }

    public String seeGoals(){
        return null;
    }

    public void addIncome(){

    }

    public String seeHistory(){
        return null;
    }

    public void createTransaction(){
        
    }


}