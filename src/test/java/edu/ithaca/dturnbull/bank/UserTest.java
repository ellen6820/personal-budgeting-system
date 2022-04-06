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

        }

        @Test
        public void seeHistoryTest(){
                User user1 = new User(0, null, null, 0, null);
                user1.createTransaction("Shopping", 10); //needs date
                user1.createTransaction("Food", 50); //needs date

                assertEquals(user1.seeHistory(), "Last 5 Transactions: \n Shopping $10 \n Food $50");
            
                assertThrows(IllegalArgumentException.class, () -> user1.createTransaction("Savings", -90)); //negative amount
                assertThrows(IllegalArgumentException.class, () -> user1.createTransaction("Savings", 1000000000)); // more than balance
        }
}
