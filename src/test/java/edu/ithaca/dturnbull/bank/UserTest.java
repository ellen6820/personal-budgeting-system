package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

        @Test
        public void createLimitTest(){

        }

        @Test
        public void addIncomeTest(){

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
            
        }
}
