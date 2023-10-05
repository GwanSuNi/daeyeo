package com.daeyeo.helloDaeyeo.exception;

public class SubAlreadyExistsException extends RuntimeException{
    public SubAlreadyExistsException(String message){
        super(message);
    }
}
