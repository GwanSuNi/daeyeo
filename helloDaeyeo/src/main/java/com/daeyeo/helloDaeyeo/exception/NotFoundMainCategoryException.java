package com.daeyeo.helloDaeyeo.exception;

/***
 * 찾으려고하는 메인 카테고리가 존재하지 않을때
 */
public class NotFoundMainCategoryException extends RuntimeException{
    public NotFoundMainCategoryException(String message){
        super(message);
    }
}
