package com.example.API_SpringBoot.error;

public class LocalNotFoundException extends Exception{
    public LocalNotFoundException(String message) {
        super(message);
    }
}
