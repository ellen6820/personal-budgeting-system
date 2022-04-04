package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParentTest{
    @Test
    void addChildTest(){
        User user = new User(0,null,null,0,null);
        Parent parent = new Parent();

        parent.addChild(0,null,null,10,"kid@gmail.com");

        assertEquals(10, child.getIncome()); //Tests if child exists by seeing if the income 
                                             //matches the value passed in while adding a child

        assertEquals(child.getEmail(), "kid@gmail.com"); //Tests if child exists by seeing if the email
                                                         //matches the value passed in while adding a child
    }

    @Test
    void setLimitTest(){

        User user = new User(0,null,null,0,null);

        Parent parent = new Parent();

        parent.addChild(60,null,null,0,null);

        parent.setLimit(50);

        assertTrue(child.getLimit(), 50); //Tests that value of limit for child is what was set by parent

    }

    @Test
    void setLockTest(){


    }

    @Test
    void seeChildHistoryTest(){


    }

}
