package org.example.main.controller.exception;

public class PickedHeroNotFoundException extends RuntimeException  {
    public PickedHeroNotFoundException() {
        super("Picked Hero Not Found");
    }
}
