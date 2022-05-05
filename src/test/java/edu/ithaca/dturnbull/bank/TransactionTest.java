package edu.ithaca.dturnbull.bank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import javax.naming.InsufficientResourcesException;
public class TransactionTest {

    static User user1;

    @BeforeEach
    void before() {
        user1 = new User(50000, 100, "example@gmail.com");
    }

    @Test
    void testNoTransaction() throws InsufficientResourcesException{
        assertEquals("Total Spent: $0.0", user1.seeHistory());
        assertEquals(0, user1.getTransactions().size());
    }

    @Test
    void testBasicTransaction() throws InsufficientResourcesException{
        user1.createTransaction("Food", 10);
        user1.createTransaction("Shopping", 20);
        user1.createTransaction("Education", 1000);

        // basic transactions object containment
        assertEquals("Food", user1.getTransactions().get(0).getType());
        assertEquals(10, user1.getTransactions().get(0).getAmount());
        assertEquals("Education", user1.getTransactions().get(2).getType());
        assertEquals(1000, user1.getTransactions().get(2).getAmount());
        assertEquals(3, user1.getTransactions().size());
    }

    @Test
    void testFillerTransaction() throws InsufficientResourcesException {
        user1.createTransaction("Food", 10);
        user1.createTransaction("Shopping", 20);
        user1.createTransaction("Education", 1000);

        // filler transactions to push past display cap
        for (int i = 0; i < 8; i++) {
            user1.createTransaction("Filler", 5);
        }

        // show that balance is affected
        assertEquals(11, user1.getTransactions().size());
        assertEquals(48930.0, user1.getBalance()); 
    }

    @Test
    void testToString() throws InsufficientResourcesException { 
        for (int i = 0; i < 11; i++) {
            user1.createTransaction("Filler", 5);
        }
        // tests string concatenation
        user1.createTransaction("Donation", 50);
        user1.createTransaction("Misc", 100);
        user1.createTransaction("Travel", 50);
        assertEquals("...\n#5: {Filler, $5.0}\n#6: {Filler, $5.0}\n#7: {Filler, $5.0}\n#8: {Filler, $5.0}\n#9: {Filler, $5.0}\n#10: {Filler, $5.0}\n#11: {Filler, $5.0}\n#12: {Donation, $50.0}\n#13: {Misc, $100.0}\n#14: {Travel, $50.0}\nTotal Spent: $235.0", user1.seeHistory());
    
    }

    @Test
    void testFamilyTransaction() throws InsufficientResourcesException {
        //Parent - child test
        Parent user2 = new Parent(10000, 200, "adult@gmail.com");
        Child userChild = new Child(100, 10, "child@gmail.com");
        user2.addChild(userChild);
        
        //child can create transactions independent of parents
        userChild.createTransaction("Food", 5);
        userChild.createTransaction("Food", 5);
        userChild.createTransaction("Food", 5);

        // tests Child object retrivement and updating
        assertEquals("Food", user2.getChildren().get(0).getTransactions().get(0).getType());
        assertEquals("Food", user2.getChildren().get(0).getTransactions().get(2).getType());
   
        // tests string concatenation through child
        assertEquals("#1: {Food, $5.0}\n#2: {Food, $5.0}\n#3: {Food, $5.0}\nTotal Spent: $15.0", user2.seeChildHistory());
    }
    
}
