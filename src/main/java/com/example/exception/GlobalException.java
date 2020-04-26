package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice //To handle exception globally
public class GlobalException extends RuntimeException {
    //RuntimeException(String message)
    //Constructs a new runtime exception with the specified detail message.
    public GlobalException(String id) {
        //super class constructor
        super("PET ID:" + id + " NOT FOUND!");
    }

    public GlobalException() {
    }
}



