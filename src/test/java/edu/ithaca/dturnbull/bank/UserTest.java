package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

        @Test
        public void createLimitTest() throws InvalidInputException{
                User user = new User(10000, 0.0,"bts@mail.com");

                assertEquals(4000.0, user.createLimit(4000.0)); //Tests initial limit

                assertEquals(20.0, user.createLimit(20.0)); //Tests new limit

                assertThrows(InvalidInputException.class, () -> user.createLimit(-300.0));//throws exception when in negative
        
        }

        @Test
        public void addIncomeTest() throws InvalidInputException{
                User user = new User(20000, 0.0,"cc@mail.com");
                assertEquals(70000.0, user.addIncome(70000.0)); //initial income

                assertEquals(25000.0, user.addIncome(25000.0));// new income

                assertThrows(InvalidInputException.class, () -> user.addIncome(0));
                assertThrows(InvalidInputException.class, () -> user.addIncome(-10000.0));
        }

        @Test
        public void setGoalTest(){
                User user1 = new User(0, null, null, 0, null);
                user1.createGoal("New York City", 100); //needs a date
                assertEquals(user1.seeGoals(), "Goal Name: New York City - $100 \n Amount Left: 100");
 
                user1.createGoal("Dyson Hairdryer", 500); //needs a date
                assertEquals(user1.seeGoals(), "Goal Name: New York City - $100 \n Amount Left: 100 \n Goal Name: Dyson Hairdryer - $500 \n Amount Left: 500");
                
                assertThrows(IllegalArgumentException.class, () -> user1.createGoal("Goal1", -90)); //negative amount
        
        }

        @Test
        public void seeHistoryTest(){
                User user1 = new User(0, null, null, 0, null);
                user1.createTransaction("Shopping", 10);
                user1.createTransaction("Food", 50); 

                assertEquals(user1.seeHistory(), "Last 5 Transactions: \n Shopping $10 \n Food $50");
            
                assertThrows(IllegalArgumentException.class, () -> user1.createTransaction("Savings", -90)); //negative amount
                assertThrows(IllegalArgumentException.class, () -> user1.createTransaction("Savings", 1000000000)); // more than balance
        }
}
