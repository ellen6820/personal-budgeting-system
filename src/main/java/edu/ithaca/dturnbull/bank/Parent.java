package edu.ithaca.dturnbull.bank;

import java.lang.reflect.Array;

public class Parent extends User{


    public Parent(double balance, Array userGoals, double income, String email) {
        this.balance = balance;

    }

    Child addChild(double balance, double spendingLimit, Array userGoals[], double income, String email){

        Child child = new Child(balance,spendingLimit,userGoals,income,email);
        return child;

    }
    
    void setLimit(double limit){

        spendingLimit = limit;

    }

    void setLock(){


    }
    
    void seeChildHistory(){


    }
}
