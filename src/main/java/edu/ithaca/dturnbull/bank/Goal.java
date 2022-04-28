package edu.ithaca.dturnbull.bank;

public class Goal {
    
    public String goals;
    public double amount;

    public Goal(String goals, double amount){
        this.goals = goals;
        this.amount = amount;
    }

    String getGoals(){
        return goals;
    }

    double getAmount(){
        return amount;
    }
}
