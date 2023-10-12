package com.daeyeo.helloDaeyeo.exception;

public class NotFoundIdException extends RuntimeException{
    public NotFoundIdException(String message){
        super(message);
    }
}
