package com.daeyeo.helloDaeyeo.exception;

/***
 * 생성하려고 하는 메인카테고리가 이미 존재할때
 */
public class MainAlreadyExistsException extends RuntimeException{
    public MainAlreadyExistsException(String message){
        super(message);
    }
}
