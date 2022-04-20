package edu.ithaca.dturnbull.bank;

public class TransactionTest {

    @Test
    void TransactionHistoryTest(){
        User user1 = new User(50000, 100, "example@gmail.com");

        assertEquals("Your last 10 Transactions: \n You have no transactions", user1.getTransactionHistory());

        user1.createTransaction("Food", 10);
        user1.createTransaction("Shopping", 20);
        user1.createTransaction("Income", 1000);

        assertEquals("Your last 10 Transactions: \n Food: $10 \n Shopping: $20 \n Income: $1000", user1.getTransactionHistory());

        user1.createTransaction("Food", 10);
        user1.createTransaction("Shopping", 20);
        user1.createTransaction("Income", 1000);
        user1.createTransaction("Food", 10);

        assertEquals("Your last 10 Transactions: \n Food: $10 \n Shopping: $20 \n Income: $1000 \n Food: $10 \n Shopping: $20 \n Income: $1000 \n Food: $10", user1.getTransactionHistory());

        user1.createTransaction("Shopping", 20);
        user1.createTransaction("Income", 1000);
        user1.createTransaction("Food", 10);

        assertEquals("Your last 10 Transactions: \n Food: $10 \n Shopping: $20 \n Income: $1000 \n Food: $10 \n Shopping: $20 \n Income: $1000 \n Food: $10 \n Shopping: $20 \n Income: $1000 \n Food: $10", user1.getTransactionHistory());
        assertEquals(52900, user1.getBalance());


        //Parent - child test
        Parent user2 = new Parent(10000, 200, "adult@gmail.com");
        User userChild = user2.addChild(100, 10, "child@gmail.com");
        
        userChild.createTransaction("Food", 5);
        userChild.createTransaction("Food", 5);
        userChild.createTransaction("Food", 5);

        assertEquals("Your last 10 Transactions: \n Food: $5 \n Food: $5 \n Food: $5 ", user2.seeChildHistory());

        userChild.createTransaction("Shopping", 10);

        assertEquals("Your last 10 Transactions: \n Food: $5 \n Food: $5 \n Food: $5 \n Shopping: $10", user2.seeChildHistory());

        user2.createTransaction("Food", 100);
        user2.createTransaction("Shopping", 20);
        user2.createTransaction("Food", 50);

        assertEquals("Your last 10 Transactions: \n Food: $100 \n Shopping: $20 \n Food: $50 ", user2.seeHistory());

        user2.createTransaction("Shopping", 50);

        assertEquals("Your last 10 Transactions: \n Food: $100 \n Shopping: $20 \n Food: $50 \n Shopping: $50", user2.seeHistory());
        
    }
    
}
