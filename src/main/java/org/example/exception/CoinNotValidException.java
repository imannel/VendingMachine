package org.example.exception;

public class CoinNotValidException extends Exception{
    public CoinNotValidException(String message) {
        super (message);
    }
}
