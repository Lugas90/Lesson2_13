package com.example.lesson2_13.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChecksAlphaException extends RuntimeException{
    public ChecksAlphaException (){
        super();
    }
}
