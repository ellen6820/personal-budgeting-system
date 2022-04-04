package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//import java.lang.reflect.Array;

public class ParentTest{
    @Test
    void addChildTest(){

        Parent parent = new Parent(0.0,"parent@gmail.com");

        Child child = parent.addChild(10.0,"kid@gmail.com");

        assertEquals(10.0, child.getBalance()); //Tests if child exists by seeing if the balance 
                                             //matches the value passed in while adding a child

        assertEquals("kid@gmail.com",child.getEmail()); //Tests if child exists by seeing if the email
                                                         //matches the value passed in while adding a child
    }

    @Test
    void setLimitTest(){

        Parent parent = new Parent(0.0,"parent@gmail.com");
        
        Child child = parent.addChild(0.0,0.0,"kid@gmail.com");

        assertEquals(child.getLimit(), 0.0); //Tests that value of limit for child matches limit from adding child

        parent.setLimit(50.0);

        assertEquals(50.0, child.getLimit()); //Tests that value of limit for child is what was set/changed by parent

    }

    @Test
    void setLockTest(){


    }

    @Test
    void seeChildHistoryTest(){


    }

}
