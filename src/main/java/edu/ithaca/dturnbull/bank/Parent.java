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

    // creates a child associated with a parent account
    Child addChild(double balance, double weeklyLimit, String email) {
        Child child = new Child(balance, weeklyLimit, email);
        children.add(child);
        return child;
    }

    // creates a child associated with a parent account
    Child addChild(Child child) {
        children.add(child);
        return child;
    }

    // allows a parent to influence a child's weekly spending limit
    void setChildLimit(Child child, double limit) {
        child.weeklyLimit = limit;
    }

    // allows a parent to see a child's most recent spending
    String seeChildHistory() {
        String output = "";
        // ArrayList<Child> children = new ArrayList<Child>();
        for (int i = 0; i < children.size(); i++) {
            output += children.get(i).seeHistory();
            // System.out.println(children.get(i).seeHistory());
            // System.out.println(children.get(i).getLimit());
        }
        return output;
    }

    // returns the child accounts under a parent
    public ArrayList<Child> getChildren() {
        return children;
    }
}
