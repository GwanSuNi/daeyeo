package com.daeyeo.daeyeoclient.common.exception;

public class RefreshTokenMissingException extends RuntimeException {
    public RefreshTokenMissingException() {
        super("Refresh 토큰을 찾을 수 없습니다.");
    }
}
