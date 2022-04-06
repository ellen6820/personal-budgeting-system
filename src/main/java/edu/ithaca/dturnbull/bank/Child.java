package edu.ithaca.dturnbull.bank;

public class Child extends User{

    public Child(double balance, double weeklyLimit, String email){
        super(balance, email);

        this.weeklyLimit = weeklyLimit;
    }

    public double getLimit(){
        return weeklyLimit;
    }



}
