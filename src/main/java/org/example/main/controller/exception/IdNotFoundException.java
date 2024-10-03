package org.example.main.controller.exception;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(Long id) {
            super(id + " not found.");
    }
}
