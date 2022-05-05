package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.naming.InsufficientResourcesException;
public class TransactionTest {


    @Test
    void TransactionHistoryTest() throws InsufficientResourcesException{
        User user1 = new User(50000, 100, "example@gmail.com");

        //no transactions
        assertEquals("Total Spent: $0.0", user1.seeHistory());

        user1.createTransaction("Food", 10);
        user1.createTransaction("Shopping", 20);
        user1.createTransaction("Education", 1000);

        assertEquals("#1: {Food, $10.0}\n#2: {Shopping, $20.0}\n#3: {Education, $1000.0}\nTotal Spent: $1030.0", user1.seeHistory());

        //less than 10 transactions
        user1.createTransaction("Food", 10);
        user1.createTransaction("Shopping", 20);
        user1.createTransaction("Education", 1000);
        user1.createTransaction("Food", 10);

        assertEquals("#1: {Food, $10.0}\n#2: {Shopping, $20.0}\n#3: {Education, $1000.0}\n#4: {Food, $10.0}\n#5: {Shopping, $20.0}\n#6: {Education, $1000.0}\n#7: {Food, $10.0}\nTotal Spent: $2070.0", user1.seeHistory());

        //10 transactions
        user1.createTransaction("Shopping", 20);
        user1.createTransaction("Education", 1000);
        user1.createTransaction("Food", 10);

        assertEquals("#1: {Food, $10.0}\n#2: {Shopping, $20.0}\n#3: {Education, $1000.0}\n#4: {Food, $10.0}\n#5: {Shopping, $20.0}\n#6: {Education, $1000.0}\n#7: {Food, $10.0}\n#8: {Shopping, $20.0}\n#9: {Education, $1000.0}\n#10: {Food, $10.0}\nTotal Spent: $3100.0", user1.seeHistory());
        assertEquals(46900.0, user1.getBalance()); //show that balance is affected

        //more than 10 transactions
        user1.createTransaction("Donation", 50);
        user1.createTransaction("Misc", 100);
        user1.createTransaction("Travel", 50);

        assertEquals("#1: {Food, $10.0}\n#2: {Shopping, $20.0}\n#3: {Education, $1000.0}\n#4: {Food, $10.0}\n#5: {Shopping, $20.0}\n#6: {Education, $1000.0}\n#7: {Food, $10.0}\n#8: {Donation, $50.0}\n#9: {Misc, $100.0}\n#10: {Travel, $50.0}\nTotal Spent: $2270.0", user1.seeHistory());

        //Parent - child test
        Parent user2 = new Parent(10000, 200, "adult@gmail.com");
        Child userChild = new Child(100, 10, "child@gmail.com");
        user2.addChild(userChild);
        
        //child can create transactions independent of parents
        userChild.createTransaction("Food", 5);
        userChild.createTransaction("Food", 5);
        userChild.createTransaction("Food", 5);
        System.out.println(userChild.transactions.size());


        assertEquals("#1: {Food, $5.0}\n#2: {Food, $5.0}\n#3: {Food, $5.0}\nTotal Spent: $15.0", user2.seeChildHistory());

        userChild.createTransaction("Shopping", 10);

        assertEquals("#1: {Food, $5.0}\n#2: {Food, $5.0}\n#3: {Food, $5.0}\n#4: {Shopping, $10.0}\nTotal Spent: $25.0", user2.seeChildHistory());

        //parent creates transactions independent of child
        user2.createTransaction("Food", 100);
        user2.createTransaction("Shopping", 20);
        user2.createTransaction("Food", 50);

        assertEquals("#1: {Food, $100.0}\n#2: {Shopping, $20.0}\n#3: {Food, $50.0}\nTotal Spent: $170.0", user2.seeHistory());

        user2.createTransaction("Shopping", 50);

        assertEquals("#1: {Food, $100.0}\n#2: {Shopping, $20.0}\n#3: {Food, $50.0}\n#4: {Shopping, $50.0}\nTotal Spent: $220.0", user2.seeHistory());
        
    }
    
}
