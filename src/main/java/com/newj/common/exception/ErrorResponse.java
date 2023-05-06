package com.newj.common.exception;

import java.util.Collections;
import org.springframework.validation.BindingResult;

public record ErrorResponse(
        int code,
        String message,
        FieldErrors fieldErrors
) {

    public static ErrorResponse of(ErrorCode errorCode) {
        return of(errorCode.code(),
                errorCode.message(),
                FieldErrors.of(Collections.emptyList()));
    }

    public static ErrorResponse of(ErrorCode errorCode, BindingResult bindingResult) {
        return of(errorCode.code(),
                errorCode.message(),
                FieldErrors.of(bindingResult));
    }

    public static ErrorResponse of(int code, String message, FieldErrors fieldErrors) {
        return new ErrorResponse(code, message, fieldErrors);
    }
}
