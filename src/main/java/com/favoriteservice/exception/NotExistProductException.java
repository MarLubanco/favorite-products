package com.favoriteservice.exception;

public class NotExistProductException extends RuntimeException {

    public NotExistProductException(String message) {
        super(message);
    }
}
