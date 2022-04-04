package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParentTest{
    @Test
    void addChildTest(){
        User user = new User(0,null,null,0,null);

        user.addChild(0,null,null,10,"kid@gmail.com");

        assertEquals(child.getIncome(), 10); //Tests if child exists by seeing if the income 
                                             //matches the value passed in while adding a child

        assertEquals(child.getEmail(), "kid@gmail.com"); //Tests if child exists by seeing if the email
                                                         //matches the value passed in while adding a child
    }

    @Test
    void setLimitTest(){


    }

    @Test
    void setLockTest(){


    }

    @Test
    void seeChildHistoryTest(){


    }

}
