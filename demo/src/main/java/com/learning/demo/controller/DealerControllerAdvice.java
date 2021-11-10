package com.learning.demo.controller;

import com.learning.demo.exception.UnableToPlaceBetException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DealerControllerAdvice {

    @ExceptionHandler(UnableToPlaceBetException.class)
    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT,
            reason = "Data integrity violation")
    public String handleUnableToPlaceBet() {
        return "unable to place bet";
    }


}

