package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.naming.InsufficientResourcesException;

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

                assertThrows(InvalidInputException.class, () -> user.addIncome(0)); //invalid amount
                assertThrows(InvalidInputException.class, () -> user.addIncome(-10000.0)); //negative amount
        }
        
        @Test
        void createTransactionTest() throws InsufficientResourcesException{ //tests the transaction constructor
            User user1 = new User(500, 100, "example@gmail.com");
    
            Transaction newPurchase = user1.createTransaction("Food", 10);

            assertEquals(newPurchase.getType(), "Food");
            assertEquals(newPurchase.getAmount(), 10);

            assertEquals(user1.getBalance(), 490);

            user1.createTransaction("Food", 100);

            assertEquals(user1.getBalance(), 390);

        }

        @Test
        public void seeHistoryTest() throws InsufficientResourcesException{
                User user1 = new User(20000, 0.0,"cc@mail.com");
                user1.createTransaction("Shopping", 10); //regular transaction
                user1.createTransaction("Food", 50); //regular transaction

                assertEquals(user1.seeHistory(), "Last 5 Transactions: \n Shopping $10 \n Food $50");
            
                assertThrows(IllegalArgumentException.class, () -> user1.createTransaction("Savings", -90)); //negative amount
                assertThrows(IllegalArgumentException.class, () -> user1.createTransaction("Savings", 1000000000)); // more than balance
        }
        

     

    
}
