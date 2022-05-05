package edu.ithaca.dturnbull.bank;

public class Limit {
    private String limitType;
    private double amount;
    private double amountSpent;

    public Limit(String limitType, double amount, double amountSpent){
        this.limitType = limitType;
        this.amount = amount;
        this.amountSpent = amountSpent;
    }

    public String getLimitType(){
        return limitType;
    }

    public double getAmount(){
        return amount;
    }

    public double getAmountSpent(){
        return amountSpent;
    }

    //the limit will reset to no money have being spent for the current time period
    public void resetLimit(){
        
    }

    //a transaction a user creates that applies to a limit affects the amount left in that limit for the time period
    public void addSpendingAmount(){

    }

    /*if a user attempts to log a transaction that results in their spending for the time period
        going over the limit for the time period, they will be notified*/
    public void overspendingLimit(){

    }

}