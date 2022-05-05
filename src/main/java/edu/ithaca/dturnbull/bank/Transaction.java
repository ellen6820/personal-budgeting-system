package edu.ithaca.dturnbull.bank;

public class Transaction{

    private double amount;
    private String type;

    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
 
    }

    String getType(){
        return type;
    }

    double getAmount(){
        return amount;
    }
    
}
