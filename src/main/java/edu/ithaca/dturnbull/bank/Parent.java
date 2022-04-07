package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;

//import java.lang.reflect.Array;

public class Parent extends User {

    public ArrayList<Child> children;

    // Constructor - calls super constructor from user
    public Parent(double balance, double weeklyLimit, String email) {
        super(balance, weeklyLimit, email);
        children = new ArrayList<Child>();
    }

    Child addChild(double balance, double weeklyLimit, String email) {
        Child child = new Child(balance, weeklyLimit, email);
        children.add(child);
        return child;
    }

    void setChildLimit(Child child, double limit) {
        child.weeklyLimit = limit;
    }

    ArrayList<Child> seeChildHistory() {
        ArrayList<Child> children = new ArrayList<Child>();
        for (int i = 0; i < children.size(); i++) {
            System.out.println(children.get(i).getBalance());
            System.out.println(children.get(i).getLimit());
            System.out.println(children.get(i).getEmail());
        }
        return children;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }
}
