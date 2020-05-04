package com.example.exception;

public class Exception extends RuntimeException {
    //RuntimeException(String message)
    //Constructs a new runtime exception with the specified detail message.
    public Exception(String id) {
        //super class constructor
        super("PET ID:" + id + " NOT FOUND!");
    }

    public Exception() {
    }
}



