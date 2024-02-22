package org.example.exception;

public class CoinNotValidException extends RuntimeException{
    public CoinNotValidException(String message) {
        super (message);
    }
}
