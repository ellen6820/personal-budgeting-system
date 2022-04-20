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

        assertEquals("Your last 10 Transactions: \n Food: $10 \n Shopping: $20 \n Income: $1000 
                        \n Food: $10 \n Shopping: $20 \n Income: $1000 
                        \n Food: $10", user1.getTransactionHistory());

        user1.createTransaction("Shopping", 20);
        user1.createTransaction("Income", 1000);
        user1.createTransaction("Food", 10);

        assertEquals("Your last 10 Transactions: \n Food: $10 \n Shopping: $20 \n Income: $1000 
                        \n Food: $10 \n Shopping: $20 \n Income: $1000 
                        \n Food: $10 \n Shopping: $20 \n Income: $1000 \n Food: $10", user1.getTransactionHistory());
        assertEquals(52900, user1.getBalance());


        //Parent - child test
        User user2 = new Parent(10000, 200, "adult@gmail.com");
        user2.addChild(100, 10, "child@gmail.com");
        
        

        
    }
    
}
