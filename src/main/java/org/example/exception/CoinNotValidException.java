package org.example.exception;

public class CoinNotYetValidException extends Exception{
    public CoinNotYetValidException(String message) {
        super (message);
    }
}
