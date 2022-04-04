package edu.ithaca.dturnbull.bank;

public class InvalidInputException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public InvalidInputException(String s) {
        super(s);
    }
    
}
