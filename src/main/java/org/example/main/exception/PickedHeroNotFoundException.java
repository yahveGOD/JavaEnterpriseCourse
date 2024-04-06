package org.example.main.exception;

public class PickedHeroNotFoundException extends RuntimeException  {
    public PickedHeroNotFoundException() {
        super("Picked Hero Not Found");
    }
}
