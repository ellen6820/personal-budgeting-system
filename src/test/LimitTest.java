package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LimitTest{

    @Test
    public void resetLimitTest(){
        //the limit will reset to no money have being spent for the current time period
    }

    @Test
    public void addSpendingAmountTest(){
        //a transaction a user creates that applies to a limit affects the amount left in that limit for the week
    }

    @Test
    public void overspendingLimitTest(){
        /*if a user attempts to log a transaction that results in their spending for the time period
        going over the limit for the time period, they will be notified*/
    }

    
}