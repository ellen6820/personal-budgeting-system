package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

//import java.lang.reflect.Array;

public class Parent extends User {


    //Constructor - calls super constructor from user 
    public Parent(double balance, double weeklyLimit, String email) {
        super(balance, weeklyLimit, email);

    }

    Child addChild(double balance, double weeklyLimit, String email){

        Child child = new Child(balance,weeklyLimit,email);

        children.add(child);

        return child;

    }
    
    void setChildLimit(Child child, double limit){

        child.weeklyLimit = limit;

    }

    void setLock(){


    }
    
    ArrayList<Child> seeChildHistory(){

        ArrayList<Child> children = new ArrayList<Child>();

        for (int i = 0; i < children.size(); i++){

            System.out.println(children.get(i).getBalance());
            System.out.println(children.get(i).getLimit());
            System.out.println(children.get(i).getEmail());

        }
        
        return children;
    }
}
