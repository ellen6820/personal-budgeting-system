package edu;

public class Limit {
    public String limitType;
    public double amount;
    public double amountSpent;

    public Limit(String limitType,double amount, double amountSpent){
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

    public void resetLimit(){
        
    }

    public void addSpendingAmount(){

    }

    public void overspendingLimit(){

    }

}