package com.newj.common.exception;

import org.springframework.http.HttpStatus;


public enum ErrorCode {
    //common
    METHOD_NOT_ALLOWED(405, HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않는 Method 입력값"),
    INVALID_INPUT_VALUE(400, HttpStatus.BAD_REQUEST, "유효하지 않은 입력값"),
    BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "bad request"),
    INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "internal server error"),

    INVALID_TOKEN_INPUT(400, HttpStatus.BAD_REQUEST, "잘못된 토큰값을 입력하였습니다");

    private final int code;
    private final HttpStatus status;
    private final String message;

    ErrorCode(int code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public HttpStatus status() {
        return status;
    }

    public String message() {
        return message;
    }

}
