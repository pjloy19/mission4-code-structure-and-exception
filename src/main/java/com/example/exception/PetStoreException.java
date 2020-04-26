package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PetStoreException {
    @ResponseBody
    @ExceptionHandler(GlobalException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String petStoreException(GlobalException exception) {
        return exception.getMessage();
    }
}
