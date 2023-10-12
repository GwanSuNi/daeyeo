package com.daeyeo.helloDaeyeo.exception;

public class IdAlreadyExistsException extends RuntimeException{
    public IdAlreadyExistsException(String message){
        super(message);
    }
}
