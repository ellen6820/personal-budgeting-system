package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

        @Test
        public void createLimitTest(){
                User user = new User("bts@mail.com");

                user.createLimit(4000.0);
                assertEquals(4000.0, user.getLimit()); //Tests initial limit

                user.createLimit(20.0);
                assertEquals(20.0, user.getLimit()); //Tests new limit

                user.createLimit(-300.0);
                assertThrows(InvalidInputException.class, () -> user.getLimit());//throws exception when in negative
        
        }

        @Test
        public void addIncomeTest(){

        }

        @Test
        public void setGoalTest(){

        }

        @Test
        public void seeHistoryTest(){
            
        }
}
