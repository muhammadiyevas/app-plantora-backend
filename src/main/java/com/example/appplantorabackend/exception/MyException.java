package com.example.appplantorabackend.exception;

import org.springframework.http.HttpStatus;

public class MyException extends RuntimeException {

    private HttpStatus status;

    public MyException(String massage, HttpStatus status) {
        super(massage);
        this.status = status;
    }

}
