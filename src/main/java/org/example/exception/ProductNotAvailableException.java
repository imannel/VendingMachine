package org.example.exception;

public class ProductNotAvailableException extends Exception {
    public ProductNotAvailableException(String message) {
        super(message);
    }
}
