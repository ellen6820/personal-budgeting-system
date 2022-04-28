package edu.ithaca.dturnbull.bank;

public class Transaction{
    //git public String date;
    public double amount;
    public String type;

    public Transaction(String type, double amount){
        this.type = type;
        this.amount = amount;
        //this.date = date;
 
    }

    String getType(){
        return type;
    }

    double getAmount(){
        return amount;
    }

    /*public void createTransaction(String type, double amount){
        Transaction newTransaction = new Transaction(type, amount);
    }

    public String getTransactionHistory(){
        return null;
    }*/
    
}
