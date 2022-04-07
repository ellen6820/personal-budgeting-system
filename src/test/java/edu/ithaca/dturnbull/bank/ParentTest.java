package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ParentTest{
    @Test
    void addChildTest(){

        Parent parent = new Parent(0.0,0.0,"parent@gmail.com");

        Child child = parent.addChild(10.0,0.0,"kid@gmail.com");

        assertEquals(10.0, child.getBalance()); //Tests if child exists by seeing if the balance 
                                             //matches the value passed in while adding a child

        assertEquals("kid@gmail.com",child.getEmail()); //Tests if child exists by seeing if the email
                                                         //matches the value passed in while adding a child
    }

    @Test
    void setLimitTest(){

        Parent parent = new Parent(0.0,0.0,"parent@gmail.com");
        
        Child child = parent.addChild(0.0,10.0,"kid@gmail.com");

        assertEquals(10.0, child.getLimit()); //Tests that value of limit for child matches limit from adding child

        parent.setChildLimit(child,50.0);

        assertEquals(50.0,child.getLimit()); //Tests that value of limit for child is what was set/changed by parent

    }

    @Test
    void setLockTest(){


    }

    @Test
    void seeChildHistoryTest(){

        Parent parent = new Parent(0.0,0.0,"parent@gmail.com");
        
        Child child1 = parent.addChild(0.0,0.0,"kid@gmail.com");

        Child child2 = parent.addChild(10.0,10.0,"kid@gmail.com");

        Child child3 = parent.addChild(50.0,10.0,"kid@gmail.com");

        ArrayList<Child> children = parent.getChildren();

        assertEquals(3, parent.getChildren().size()); // Tests that all 3 children are correctly inserted into list

        assertEquals (0.0, children.get(0).getBalance()); //Tests balance of first child in list

        assertEquals (10.0, children.get(1).getBalance()); //Tests balance of second child in list 

        assertEquals (50.0, children.get(2).getBalance()); //Tests balance of third child in list 


    }

}
