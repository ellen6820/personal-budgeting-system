package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

        @Test
        public void createLimitTest() throws InvalidInputException{
                User user = new User(10000, "bts@mail.com");

                assertEquals(4000.0, user.createLimit(4000.0)); //Tests initial limit

                assertEquals(20.0, user.createLimit(20.0)); //Tests new limit

                assertThrows(InvalidInputException.class, () -> user.createLimit(-300.0));//throws exception when in negative
        
        }

        @Test
        public void addIncomeTest() throws InvalidInputException{
                User user = new User(20000, "cc@mail.com");
                assertEquals(70000.0, user.addIncome(70000.0)); //initial income

                assertEquals(25000.0, user.addIncome(25000.0));// new income

                assertThrows(InvalidInputException.class, () -> user.addIncome(0));
                assertThrows(InvalidInputException.class, () -> user.addIncome(-10000.0));
        }

        @Test
        public void setGoalTest(){

        }

        @Test
        public void seeHistoryTest(){
            
        }
}
