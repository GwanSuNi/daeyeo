package com.daeyeo.daeyeoclient.common.exception;

public class AccessTokenMissingException extends RuntimeException {
    public AccessTokenMissingException() {
        super("Access 토큰을 찾을 수 없습니다.");
    }
}
