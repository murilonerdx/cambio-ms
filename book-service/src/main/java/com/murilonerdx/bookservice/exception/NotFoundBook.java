package com.murilonerdx.bookservice.exception;

public class NotFoundBook extends RuntimeException{
    public NotFoundBook(String message) {
        super(message);
    }
}
