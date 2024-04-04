package org.example.main.exception;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(long id) {
            super(id + " not found.");
    }
}
