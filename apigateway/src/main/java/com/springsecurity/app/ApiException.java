package com.springsecurity.app;

import lombok.Getter;


/**
 * @author BGH58082
 *
 */
public class ApiException extends RuntimeException {
    @Getter
    protected String errorCode;

    public ApiException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
