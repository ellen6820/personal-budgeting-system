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

    public void createLimit(double weeklyLimit){

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