package edu.ithaca.dturnbull.bank;

//import java.lang.reflect.Array;

public class Parent extends User{


    //Constructor - calls super constructor from user 
    public Parent(double balance, String email) {
        super(balance, email);

    }

    Child addChild(double balance, String email){

        Child child = new Child(balance,weeklyLimit,email);

        return child;

    }
    
    void setLimit(double limit){

        weeklyLimit = limit;

    }

    void setLock(){


    }
    
    void seeChildHistory(){


    }
}
