package com.newj.common.exception;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.validation.BindingResult;

public record FieldErrors(
        List<FieldError> fieldErrors
) {
    public static FieldErrors of(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream()
                .map(FieldError::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), FieldErrors::new));
    }

    public static FieldErrors of(List<FieldError> fieldErrors) {
        return new FieldErrors(fieldErrors);
    }

    public record FieldError(
            String field,
            String value,
            String reason
    ) {

        public static FieldError of(String field, String value, String reason) {
            return new FieldError(field, value, reason);
        }

        public static FieldError of(org.springframework.validation.FieldError fieldError) {
            return of(
                    fieldError.getField(),
                    (fieldError.getRejectedValue() == null) ? ""
                            : fieldError.getRejectedValue().toString(),
                    fieldError.getDefaultMessage()
            );
        }
    }

}
