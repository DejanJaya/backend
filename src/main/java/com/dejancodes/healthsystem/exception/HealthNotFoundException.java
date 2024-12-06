package com.dejancodes.healthsystem.exception;

public class HealthNotFoundException extends RuntimeException {
    public HealthNotFoundException(int id) {
        super("Could not found the health with id "+ id);
    }
}
