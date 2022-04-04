package edu.ithaca.dturnbull.bank;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User{
    
    public double balance;
    public double weeklyLimit;
    public ArrayList<String> userGoals; //Change to ArrayList of goals
    public double income;
    public String email;

    public User(double balance, String email){
        this.balance = balance;
        this.email = email;
    }

    
    public String getEmail(){
        return email;
    }
    
    public double getBalance(){
        return balance;
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