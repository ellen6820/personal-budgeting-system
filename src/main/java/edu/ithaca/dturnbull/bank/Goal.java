package edu.ithaca.dturnbull.bank;

public class Goal {
    private String goals;
    private double amount;
    private double amountSaved;

    public Goal(String goals, double amount){
        this.goals = goals;
        this.amount = amount;
    }

    /**
     * Allows user to update progress towards goal
     */
    void addToGoal(double newAmount){
        amountSaved += newAmount;
    }

    /**
     * @return how much user has saved and how much is left to complete a goal
     */
    String checkProgress(){
        String progress = "You are $" + (amount - amountSaved) + " dollars away from your goal."; 
        return progress;
    }

    /**
     * 
     * @return a list of the user's goals
     */
    String getGoals(){
        return goals;
    }


    /**
     * 
     * @return the amount a user wants to save for a specific goal
     */
    double getAmount(){
        return amount;
    }
}
