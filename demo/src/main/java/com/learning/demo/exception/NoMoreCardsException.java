package com.learning.demo.exception;

public class NoMoreCardsException extends RuntimeException {
    public NoMoreCardsException(String message) {
        super(message);
    }
}
