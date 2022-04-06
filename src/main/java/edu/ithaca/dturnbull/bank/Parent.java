package edu.ithaca.dturnbull.bank;

//import java.lang.reflect.Array;

public class Parent extends User {


    //Constructor - calls super constructor from user 
    public Parent(double balance, double weeklyLimit, String email) {
        super(balance, weeklyLimit, email);

    }

    Child addChild(double balance, double weeklyLimit, String email){

        Child child = new Child(balance,weeklyLimit,email);

        return child;

    }
    
    void setChildLimit(Child child,double limit){

        child.weeklyLimit = limit;

    }

    void setLock(){


    }
    
    void seeChildHistory(){


    }
}
